package com.lz.bitcoinexplorer1113.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


public interface BlockService {
    String syncBlock(String blockhash);


    void syncBlocks(String fromBlockhash);
}
