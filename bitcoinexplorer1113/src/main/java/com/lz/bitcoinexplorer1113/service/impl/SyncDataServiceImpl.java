package com.lz.bitcoinexplorer1113.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lz.bitcoinexplorer1113.client.JsonRpcBitcoinClient;
import com.lz.bitcoinexplorer1113.client.RestBitcoinClient;
import com.lz.bitcoinexplorer1113.dao.BlockMapper;
import com.lz.bitcoinexplorer1113.dao.TransactionDetailMapper;
import com.lz.bitcoinexplorer1113.dao.TransactionMapper;
import com.lz.bitcoinexplorer1113.enumeration.TransactionDetailType;
import com.lz.bitcoinexplorer1113.po.Block;
import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.po.TransactionDetail;
import com.lz.bitcoinexplorer1113.service.SyncDataService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SyncDataServiceImpl implements SyncDataService {
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @Autowired
    private JsonRpcBitcoinClient jsonRpcBitcoinClient;


    @Autowired
    private RestBitcoinClient bitcoinClient;

    @Async
    public String syncBlock(String blockhash) {
        JSONObject blockJson = bitcoinClient.getBlockNoTxDetails(blockhash);
        Integer height=blockJson.getInteger("height");
        Block b=blockMapper.selectByHeight(height);
        if(b!=null){
            return null;
        }
        Block block = new Block();
        block.setBlockhash(blockJson.getString("hash"));
        block.setConfirmations(blockJson.getInteger("confirmations"));
        block.setHeight(blockJson.getInteger("height"));
        block.setTime(blockJson.getLong("time"));
        block.setDifficulty(blockJson.getDouble("difficulty"));
        block.setSizeondisk(blockJson.getInteger("size"));
        block.setMerkleRoot(blockJson.getString("merkleroot"));
        block.setTxsize(blockJson.getInteger("nTx"));
        block.setVersion(blockJson.getString("versionHex"));
        block.setNonce(blockJson.getInteger("nonce"));
        block.setWeight(blockJson.getInteger("weight"));
        block.setBits(blockJson.getString("bits"));


        blockMapper.insert(block);

        String nextblockhash = blockJson.getString("nextblockhash");
        return nextblockhash;
    }


    public String syncBlocks(String fromBlockhash) {
        String tempBlockhash = fromBlockhash;
        while (tempBlockhash != null){
            tempBlockhash = syncBlock(tempBlockhash);
        }
        return  tempBlockhash;
    }











    public String insertpreinitblock(String preblockhash) throws Throwable {

        JSONObject blockInfo = bitcoinClient.getBlockInfo(preblockhash);
        Integer height=blockInfo.getInteger("height");
        Block b=blockMapper.selectByHeight(height);
        if(b!=null){
            return null;
        }
        Block block = new Block();
        block.setBlockhash(blockInfo.getString("hash"));
        block.setConfirmations(blockInfo.getInteger("confirmations"));
        block.setHeight(blockInfo.getInteger("height"));
        block.setTime(blockInfo.getLong("time"));
        block.setDifficulty(blockInfo.getDouble("difficulty"));
        block.setSizeondisk(blockInfo.getInteger("size"));
        block.setMerkleRoot(blockInfo.getString("merkleroot"));
        block.setTxsize(blockInfo.getInteger("nTx"));
        block.setVersion(blockInfo.getString("versionHex"));
        block.setNonce(blockInfo.getInteger("nonce"));
        block.setWeight(blockInfo.getInteger("weight"));
        block.setBits(blockInfo.getString("bits"));
        String previousblockhash = blockInfo.getString("previousblockhash");
        JSONArray tx = blockInfo.getJSONArray("tx");

        blockMapper.insert(block);
        insertTransaction(tx,block.getBlockId(),block.getConfirmations(),block.getTime());
        return previousblockhash;
    }

    public void insertTransaction(JSONArray txs, Integer blockid, Integer confirmations,Long time) throws Throwable {
        for(int i=0;i<txs.size();i++){
            Transaction tran = new Transaction();
            JSONObject tx = txs.getJSONObject(i);
            tran.setTxid(tx.getString("txid"));
            tran.setTxhash(tx.getString("hash"));
            tran.setBlockId(blockid);
            tran.setConfirmations(confirmations);
            tran.setSizeondisk(tx.getInteger("size"));
             tran.setTime(time);
            tran.setStatus((byte)0);
             // todo amount input output
            transactionMapper.insert(tran);
            JSONArray vouts = tx.getJSONArray("vout");
            JSONArray vins = tx.getJSONArray("vin");

             insertTransactionDetailVin(vins,tran.getTransactionId());
            insertTransactionDetailVout(vouts,tran.getTransactionId());

        }
    }


    public void syncTransactionByHash(String txid, Integer blockId, Long time) throws Throwable {
        JSONObject transactionJson = bitcoinClient.getTransaction(txid);
        Transaction transaction = new Transaction();
        //set amount
        transaction.setBlockId(blockId);
        transaction.setSizeondisk(transactionJson.getInteger("size"));
        transaction.setStatus((byte)0);
        transaction.setTime(time);
        transaction.setTxhash(transactionJson.getString("hash"));
        transaction.setTxid(transactionJson.getString("txid"));
        transaction.setWeight(transactionJson.getInteger("weight"));

        transactionMapper.insert(transaction);

        JSONArray vouts = transactionJson.getJSONArray("vout");
        JSONArray vins = transactionJson.getJSONArray("vin");
        insertTransactionDetailVin(vins,transaction.getTransactionId());
        insertTransactionDetailVout(vouts,transaction.getTransactionId());

    }


    public void insertTransactionDetailVin(JSONArray vins,Integer transactionId) throws Throwable {
        for (int i=0;i<vins.size();i++) {
            JSONObject vin = vins.getJSONObject(i);
            Integer indexvout = vin.getInteger("vout");
            String txid = vin.getString("txid");
            if(txid!=null){
                JSONObject rawTransaxtion = jsonRpcBitcoinClient.getRawTransaxtion(txid);
                JSONArray vouts = rawTransaxtion.getJSONArray("vout");
                JSONObject vout = vouts.getJSONObject(indexvout);
                TransactionDetail td = new TransactionDetail();

                JSONObject scriptPubKey = vout.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if(addresses!=null){
                    String string = addresses.getString(0);
                    td.setTransactionId(transactionId);
                    td.setType((byte)TransactionDetailType.send.ordinal());
                    td.setAmount(-vout.getDouble("value"));
                    td.setAddress(string);
                    transactionDetailMapper.insert(td);
                }
            }
        }

    }
    public void insertTransactionDetailVout(JSONArray vouts,Integer transactionId){
        Double sum = 0.0;
        for (int i=0;i<vouts.size();i++) {
            JSONObject vout = vouts.getJSONObject(i);
            TransactionDetail td = new TransactionDetail();

            JSONObject scriptPubKey = vout.getJSONObject("scriptPubKey");
            JSONArray addresses = scriptPubKey.getJSONArray("addresses");
            if(addresses!=null){
            String string = addresses.getString(0);

                td.setTransactionId(transactionId);
                td.setType((byte)TransactionDetailType.reseive.ordinal());
                td.setAmount(vout.getDouble("value"));
                td.setAddress(string);
                transactionDetailMapper.insert(td);
                sum+=td.getAmount();
            }

        }
    }




    public String preinitBlocks(String fromBlockhash) throws Throwable {
        String tempBlockhash = fromBlockhash;
        int i=0;
        while (i<1000){
            tempBlockhash = insertpreinitblock(tempBlockhash);
            i++;
        }
        return tempBlockhash;
    }







}
