package com.lz.bitcoinexplorer1113;

import com.alibaba.fastjson.JSONObject;
import com.lz.bitcoinexplorer1113.client.RestBitcoinClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class Bitcoinexplorer1113ApplicationTests {
    @Autowired
    private RestBitcoinClient bitcoinRest;
    @Test
    void contextLoads() {




            JSONObject chainInfo = bitcoinRest.getChainInfo();
            JSONObject blockhashByHeight = bitcoinRest.getBlockhashByHeight(10);
            List<JSONObject> blockHeaders = bitcoinRest.getBlockHeaders(5, "0000000000000183691e29729ea6cec432fa9d3521507fd7c728a2893dcdb708");
            JSONObject blockNoTxDetails = bitcoinRest.getBlockNoTxDetails("00000000001c31eefd455987ae4b805a961edbb2df195b57d0b1481c4c9d5f80");
            JSONObject blockInfo = bitcoinRest.getBlockInfo("00000000001c31eefd455987ae4b805a961edbb2df195b57d0b1481c4c9d5f80");
            JSONObject tx = bitcoinRest.getTransaction("e00fd08ec52cc53312a3d97ee91c0662d952c564534aceb84a8e038a73230019");
            JSONObject mempoolInfo = bitcoinRest.getMempoolInfo();
            JSONObject mempoolContents = bitcoinRest.getMempoolContents();
            JSONObject utxo = bitcoinRest.getUTXO("e00fd08ec52cc53312a3d97ee91c0662d952c564534aceb84a8e038a73230019", 0);


    }

}
