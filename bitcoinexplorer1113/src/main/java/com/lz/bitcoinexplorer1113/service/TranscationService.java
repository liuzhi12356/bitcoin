package com.lz.bitcoinexplorer1113.service;

import com.lz.bitcoinexplorer1113.po.Transaction;

import java.util.List;

public interface TranscationService {
    int deleteByPrimaryKey(Integer transactionId);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer transactionId);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
    void truncate();
    public List<Transaction> getuntxs();
}
