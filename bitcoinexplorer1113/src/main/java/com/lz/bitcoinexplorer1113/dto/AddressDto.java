package com.lz.bitcoinexplorer1113.dto;

import com.github.pagehelper.PageInfo;
import com.lz.bitcoinexplorer1113.po.Transaction;

import java.util.List;

public class AddressDto {
    private String address;
    private final String format="BASE58 (P2SH)";
    private Integer txSize;
    private double totalReceived;
    private double totalSent;
    private double finalbalance;
    private PageInfo<TransactionDto> transactions;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFormat() {
        return format;
    }

    public Integer getTxSize() {
        return txSize;
    }

    public void setTxSize(Integer txSize) {
        this.txSize = txSize;
    }

    public double getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(double totalReceived) {
        this.totalReceived = totalReceived;
    }

    public double getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(double totalSent) {
        this.totalSent = totalSent;
    }





    public double getFinalbalance() {
        return finalbalance;
    }

    public void setFinalbalance(double finalbalance) {
        this.finalbalance = finalbalance;
    }

    public PageInfo<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(PageInfo<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
