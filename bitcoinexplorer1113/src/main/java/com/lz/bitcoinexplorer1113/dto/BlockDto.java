package com.lz.bitcoinexplorer1113.dto;

import com.github.pagehelper.PageInfo;
import com.lz.bitcoinexplorer1113.po.Block;
import com.lz.bitcoinexplorer1113.po.Transaction;

import java.util.List;

public class BlockDto extends Block {
    private PageInfo<TransactionDto> transactions;
    private String timeFormat;



    public PageInfo<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(PageInfo<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }
}
