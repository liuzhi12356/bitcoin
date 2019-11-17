package com.lz.bitcoinexplorer1113.dto;

import com.github.pagehelper.PageInfo;
import com.lz.bitcoinexplorer1113.po.Block;
import com.lz.bitcoinexplorer1113.po.Transaction;

import java.util.List;

public class BlockDto extends Block {
    private PageInfo<TransactionDto> transactions;


    public PageInfo<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(PageInfo<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
