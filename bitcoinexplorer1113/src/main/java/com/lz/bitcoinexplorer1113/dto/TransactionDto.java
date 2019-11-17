package com.lz.bitcoinexplorer1113.dto;

import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.po.TransactionDetail;

import java.util.List;

public class TransactionDto extends Transaction {
    private List<TransactionDetailsDto> transactionDetails;


    public List<TransactionDetailsDto> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetailsDto> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
