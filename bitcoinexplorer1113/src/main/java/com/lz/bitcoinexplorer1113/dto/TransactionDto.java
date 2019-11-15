package com.lz.bitcoinexplorer1113.dto;

import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.po.TransactionDetail;

import java.util.List;

public class TransactionDto extends Transaction {
    private List<TransactionDetail> transactionDetails;

    public List<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }


}
