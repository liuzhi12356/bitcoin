package com.lz.bitcoinexplorer1113.service;

import org.springframework.stereotype.Service;


public interface SyncDataService {
    String syncBlock(String blockhash);


    String syncBlocks(String fromBlockhash);



    public String preinitBlocks(String fromBlockhash) throws Throwable;
}
