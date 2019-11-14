package com.lz.bitcoinexplorer1113.dao;

import com.lz.bitcoinexplorer1113.po.Transaction;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer transactionId);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer transactionId);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
    void truncate();
}