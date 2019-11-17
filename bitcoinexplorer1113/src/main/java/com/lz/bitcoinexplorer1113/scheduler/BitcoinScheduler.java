package com.lz.bitcoinexplorer1113.scheduler;

import com.lz.bitcoinexplorer1113.service.SyncDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BitcoinScheduler {
    private Logger logger= LoggerFactory.getLogger(BitcoinScheduler.class);
    @Autowired
    private SyncDataService syncDataService;

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
}
