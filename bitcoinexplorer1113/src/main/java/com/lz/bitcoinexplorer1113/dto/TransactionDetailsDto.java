package com.lz.bitcoinexplorer1113.dto;

import com.lz.bitcoinexplorer1113.enumeration.TransactionDetailType;
import com.lz.bitcoinexplorer1113.po.TransactionDetail;

public class TransactionDetailsDto extends TransactionDetail {
    private TransactionDetailType transactionDetailType;

    public TransactionDetailType getTransactionDetailType() {
        return TransactionDetailType.values()[this.getType()];
    }


}
