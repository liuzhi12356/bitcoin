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


}
