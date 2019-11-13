package com.lz.bitcoinexplorer1113.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class BitcoinScheduler {
    private Logger logger= LoggerFactory.getLogger(BitcoinScheduler.class);

    @Scheduled()
    public void bitcoinscheduler(){
        logger.info("show");
    }
}
