package com.lz.bitcoinexplorer1113.scheduler;

import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.service.SyncDataService;
import com.lz.bitcoinexplorer1113.service.TranscationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    /*@Scheduled(fixedRate = 3000)
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
    }*/

    @Scheduled(fixedRate = 2000)
    public void sendUntx(){
        final List<Transaction> getuntxs = transcationService.getuntxs();
        simpMessagingTemplate.convertAndSend("/bitcoin/untx",getuntxs);
    }

}
