package com.lz.bitcoinexplorer1113.service;

import com.lz.bitcoinexplorer1113.po.TransactionDetail;

public interface TranscationDetailService {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);
    void truncate();
}
