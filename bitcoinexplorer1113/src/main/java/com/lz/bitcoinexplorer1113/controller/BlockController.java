package com.lz.bitcoinexplorer1113.controller;

import com.alibaba.fastjson.JSONObject;
import com.lz.bitcoinexplorer1113.client.RestBitcoinClient;
import com.lz.bitcoinexplorer1113.dao.BlockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/btc")
@RestController
@CrossOrigin
@EnableAutoConfiguration
public class BlockController {


    @RequestMapping("block/{hash}")
    public JSONObject GetBlockByHash(@PathVariable String hash){
        return null;
    }
    @RequestMapping("/blocks")
    public List<JSONObject> GetBlocks(){
        return null;
    }
    @RequestMapping("/blocks/{page}")
    public List<JSONObject> GetBlocksByPage(){
        return null;
    }
    @GetMapping("block/{height}")
    public JSONObject GetBlockByHeight(@RequestParam Integer height){
        return null;
    }

    @RequestMapping("/address{address}")
    public JSONObject GetinfoByAddress(){
        return null;
    }
}
