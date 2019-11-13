package com.lz.bitcoinexplorer1113.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.lz.bitcoinexplorer1113.client.RestBitcoinClient;
import com.lz.bitcoinexplorer1113.dao.BlockMapper;
import com.lz.bitcoinexplorer1113.po.Block;
import com.lz.bitcoinexplorer1113.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private RestBitcoinClient bitcoinClient;

    @Async
    public String syncBlock(String blockhash) {
        JSONObject blockJson = bitcoinClient.getBlockNoTxDetails(blockhash);
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


    public void syncBlocks(String fromBlockhash) {
        String tempBlockhash = fromBlockhash;
        while (tempBlockhash != null){
            tempBlockhash = syncBlock(tempBlockhash);
        }
    }
}
