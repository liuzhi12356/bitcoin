package com.lz.bitcoinexplorer1113.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lz.bitcoinexplorer1113.client.RestBitcoinClient;
import com.lz.bitcoinexplorer1113.dao.TransactionMapper;
import com.lz.bitcoinexplorer1113.dto.AddressDto;
import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.service.TranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TranscationServiceImpl implements TranscationService {
    @Autowired
    private TransactionMapper transactionMapper;
    
    @Autowired
    private RestBitcoinClient restBitcoinClient;

    @Override
    public int deleteByPrimaryKey(Integer transactionId) {
        return 0;
    }

    @Override
    public int insert(Transaction record) {
        return 0;
    }

    @Override
    public int insertSelective(Transaction record) {
        return 0;
    }

    @Override
    public Transaction selectByPrimaryKey(Integer transactionId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Transaction record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Transaction record) {
        return 0;
    }

    @Override
    public void truncate() {

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
    public List<Transaction> gettxByaddress(String address) {
        return transactionMapper.gettxByaddress(address);
    }
}
