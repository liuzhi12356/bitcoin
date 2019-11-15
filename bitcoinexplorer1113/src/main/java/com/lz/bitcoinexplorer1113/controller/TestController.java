package com.lz.bitcoinexplorer1113.controller;

import com.alibaba.fastjson.JSONObject;
import com.lz.bitcoinexplorer1113.client.JsonRpcBitcoinClient;
import com.lz.bitcoinexplorer1113.client.RestBitcoinClient;
import com.lz.bitcoinexplorer1113.service.SyncDataService;
import com.lz.bitcoinexplorer1113.service.TranscationService;
import com.lz.bitcoinexplorer1113.vo.SerObject;
import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;

@RequestMapping("/test")
@RestController
@EnableAutoConfiguration
public class TestController {
    @Autowired
    private RestBitcoinClient bitcoinRest;
    @Autowired
    private SyncDataService syncDataService;
    @Autowired
    private JsonRpcBitcoinClient jsonRpcBitcoinClient;
    @Autowired
    private TranscationService transcationService;


    @GetMapping("/hello")
    public String hello(){
        JSONObject chainInfo = bitcoinRest.getChainInfo();
        JSONObject blockhashByHeight = bitcoinRest.getBlockhashByHeight(10);
        List<JSONObject> blockHeaders = bitcoinRest.getBlockHeaders(5, "0000000000000183691e29729ea6cec432fa9d3521507fd7c728a2893dcdb708");
        JSONObject blockNoTxDetails = bitcoinRest.getBlockNoTxDetails("00000000001c31eefd455987ae4b805a961edbb2df195b57d0b1481c4c9d5f80");
        JSONObject blockInfo = bitcoinRest.getBlockInfo("00000000001c31eefd455987ae4b805a961edbb2df195b57d0b1481c4c9d5f80");
        JSONObject tx = bitcoinRest.getTransaction("e00fd08ec52cc53312a3d97ee91c0662d952c564534aceb84a8e038a73230019");
        JSONObject mempoolInfo = bitcoinRest.getMempoolInfo();
        JSONObject mempoolContents = bitcoinRest.getMempoolContents();
        JSONObject utxo = bitcoinRest.getUTXO("e00fd08ec52cc53312a3d97ee91c0662d952c564534aceb84a8e038a73230019", 0);
        return null;
    }

    @GetMapping("/init")
    public void init() throws Throwable {
        String bestBlockhash = jsonRpcBitcoinClient.getBestBlockhash();

        String lasthash = syncDataService.preinitBlocks(bestBlockhash);
        SerObject serObject = new SerObject();
        serObject.setBesthash(bestBlockhash);
        serObject.setLasthash(lasthash);
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("f:/serobject.txt")));
        oos.writeObject(serObject);
    }
    @GetMapping("/untxs")
    public void untxs(){
        transcationService.getuntxs();
    }
}
