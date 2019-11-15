package com.lz.bitcoinexplorer1113.service.impl;

import com.lz.bitcoinexplorer1113.dao.TransactionDetailMapper;
import com.lz.bitcoinexplorer1113.po.TransactionDetail;
import com.lz.bitcoinexplorer1113.service.TranscationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscationDetailServiceImpl implements TranscationDetailService {
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;


    @Override
    public int deleteByPrimaryKey(Long txDetailId) {
        return 0;
    }

    @Override
    public int insert(TransactionDetail record) {
        return 0;
    }

    @Override
    public int insertSelective(TransactionDetail record) {
        return 0;
    }

    @Override
    public TransactionDetail selectByPrimaryKey(Long txDetailId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TransactionDetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TransactionDetail record) {
        return 0;
    }

    @Override
    public void truncate() {

    }
}
