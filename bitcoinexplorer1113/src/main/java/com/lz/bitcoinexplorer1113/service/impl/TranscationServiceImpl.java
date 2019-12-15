package com.lz.bitcoinexplorer1113.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lz.bitcoinexplorer1113.client.RestBitcoinClient;
import com.lz.bitcoinexplorer1113.dao.TransactionMapper;
import com.lz.bitcoinexplorer1113.dto.AddressDto;
import com.lz.bitcoinexplorer1113.dto.TransactionDto;
import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.service.TranscationService;
import com.lz.bitcoinexplorer1113.util.TimeFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TranscationServiceImpl
        implements TranscationService {
    @Autowired
    private TransactionMapper transactionMapper;
    
    @Autowired
    private RestBitcoinClient restBitcoinClient;

    @Override
    public int deleteByPrimaryKey(Integer transactionId) {
        return transactionMapper.deleteByPrimaryKey(transactionId);
    }

    @Override
    public int insert(Transaction record) {
        return transactionMapper.insert(record);
    }

    @Override
    public int insertSelective(Transaction record) {
        return transactionMapper.insertSelective(record);
    }

    @Override
    public Transaction selectByPrimaryKey(Integer transactionId) {
        return transactionMapper.selectByPrimaryKey(transactionId);
    }

    @Override
    public int updateByPrimaryKeySelective(Transaction record) {
        return transactionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Transaction record) {
        return transactionMapper.updateByPrimaryKey(record);
    }

    @Override
    public void truncate() {
              transactionMapper.truncate();
    }


    /**
     * 获取tx池中所有交易
     */
    public List<Transaction> getuntxs(){
        JSONObject mempoolContents = restBitcoinClient.getMempoolContents();
        ArrayList<Transaction> list = new ArrayList<>();
        
        Set<String> strings = mempoolContents.keySet();
        for (String string : strings) {
            Transaction transaction = new Transaction();
          JSONObject o = mempoolContents.getJSONObject(string);
          transaction.setTxhash(string);
          transaction.setTime(o.getLong("time"));
          transaction.setFees(o.getDouble("fee"));
          transaction.setTimeFormat(TimeFormatUtil.nowTimes(o.getLong("time")));
          list.add(transaction);
        }
        Collections.sort(list,Transaction::compareTo);

        return list;

    }

    @Override
    public AddressDto address(String address) {
        return transactionMapper.address(address);
    }

    @Override
    public List<TransactionDto> gettxByaddress(String address) {

        return transactionMapper.gettxByaddress(address);
    }

    @Override
    public List<TransactionDto> gettransacionsByBlockId(Integer blockId) {
        return transactionMapper.gettransacionsByBlockId(blockId);
    }

    @Override
    public TransactionDto gettxByhash(String hash) {
        return transactionMapper.gettxByhash(hash);
    }


    private JSONObject oldObject=new JSONObject();
    private ArrayList<Transaction> trans=new ArrayList<>();

    @Override
    public List<Transaction> untxs() {
        trans=new ArrayList<>();
        JSONObject mempoolContents = restBitcoinClient.getMempoolContents();
        Set<String> strings = mempoolContents.keySet();
        for (String string : strings) {
            if(!oldObject.containsKey(string)){
                JSONObject jsonObject = mempoolContents.getJSONObject(string);
                Transaction transaction = new Transaction();
                JSONObject o = mempoolContents.getJSONObject(string);
                transaction.setTxhash(string);
                transaction.setTime(o.getLong("time"));
                transaction.setFees(o.getDouble("fee"));
                transaction.setTimeFormat(TimeFormatUtil.nowTimes(o.getLong("time")));
                trans.add(transaction);
            }
        }
        oldObject=mempoolContents;

        List<Transaction> collect = trans.stream().sorted((t1, t2) -> {
            return (int) (t2.getTime() - t1.getTime());
        }).collect(Collectors.toList());
        return collect;
    }
}
