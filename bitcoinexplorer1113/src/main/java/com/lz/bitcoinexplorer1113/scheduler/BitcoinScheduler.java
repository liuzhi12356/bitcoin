package com.lz.bitcoinexplorer1113.scheduler;

import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.service.SyncDataService;
import com.lz.bitcoinexplorer1113.service.TranscationService;
import com.lz.bitcoinexplorer1113.vo.SerObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class BitcoinScheduler {
    private Logger logger= LoggerFactory.getLogger(BitcoinScheduler.class);
    @Autowired
    private SyncDataService syncDataService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private TranscationService transcationService;

    @Scheduled(cron =  "${bitcoin.sync.interval}")
    public void bitcoinscheduler() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("f:/serobject.txt")));
        SerObject o = (SerObject)ois.readObject();
        String besthash = o.getBesthash();
        logger.info("show"+besthash);
        String s = syncDataService.syncBlocks(besthash);
        if(besthash!=s&&s!=null){
            o.setBesthash(s);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("f:/serobject.txt")));
            oos.writeObject(o);
        }
    }

   @Scheduled(cron = "${bitcoin.syncMempoolTx.interval}")
    public void sendUntx(){
       logger.info("未确认交易推送");
        List<Transaction> untxs = transcationService.untxs();
        simpMessagingTemplate.convertAndSend("/bitcoin/untx",untxs);

    }

 @Scheduled(cron = "${bitcoin.syncMempoolTx.interval}")
    public void sendMoreUntx(){
     logger.info("更多交易推送");
        List<Transaction> getuntxs = transcationService.getuntxs();
        simpMessagingTemplate.convertAndSend("/bitcoin/moreuntx",getuntxs);
        System.out.println("end");
    }




}
