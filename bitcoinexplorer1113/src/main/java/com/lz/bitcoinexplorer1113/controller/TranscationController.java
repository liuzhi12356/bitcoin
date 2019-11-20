package com.lz.bitcoinexplorer1113.controller;

import com.alibaba.fastjson.JSONObject;
import com.lz.bitcoinexplorer1113.dto.TransactionDto;
import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.service.TranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tx")
@RestController
@CrossOrigin
@EnableAutoConfiguration
public class TranscationController {
    @Autowired
    private TranscationService transcationService;

    @RequestMapping("/getbyhash/{hash}")
    public TransactionDto gettranscationByHash(@PathVariable String hash){
        TransactionDto transactionDto=transcationService.gettxByhash(hash);
        return transactionDto;
    }


    /*@MessageMapping("/getRecentUnconfirmed")
    @SendTo("/bitcoin/tran")*/
    @RequestMapping("/getRecentUnconfirmed")
    public List<Transaction> getRecentUnconfirmed(@RequestParam(required = false, defaultValue = "15") Integer size, @RequestParam(defaultValue = "0") Integer status){
        List<Transaction> getuntxs = transcationService.getuntxs();
        for (Transaction getuntx : getuntxs) {
            System.out.println(getuntx.getTime());
        }
        return transcationService.getuntxs();
    }

}
