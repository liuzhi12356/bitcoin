package com.lz.bitcoinexplorer1113.service.impl;

import com.lz.bitcoinexplorer1113.dao.TransactionMapper;
import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.service.TranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscationServiceImpl implements TranscationService {
    @Autowired
    private TransactionMapper transactionMapper;

}
