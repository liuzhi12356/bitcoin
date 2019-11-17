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
        return transactionDetailMapper.deleteByPrimaryKey(txDetailId);
    }

    @Override
    public int insert(TransactionDetail record) {
        return transactionDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(TransactionDetail record) {
        return transactionDetailMapper.insert(record);
    }

    @Override
    public TransactionDetail selectByPrimaryKey(Long txDetailId) {
        return transactionDetailMapper.selectByPrimaryKey(txDetailId);
    }

    @Override
    public int updateByPrimaryKeySelective(TransactionDetail record) {
        return transactionDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TransactionDetail record) {
        return transactionDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void truncate() {
         transactionDetailMapper.truncate();
    }
}
