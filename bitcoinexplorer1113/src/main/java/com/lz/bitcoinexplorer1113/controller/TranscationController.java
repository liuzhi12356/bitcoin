package com.lz.bitcoinexplorer1113.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tx")
@RestController
@CrossOrigin
@EnableAutoConfiguration
public class TranscationController {

    @RequestMapping("/getbyhash/{hash}")
    public JSONObject gettranscationByHash(){
        return null;
    }

    @GetMapping("/getRecentUnconfirmed")
    public List<JSONObject> getRecentUnconfirmed(@RequestParam(required = false, defaultValue = "15") Integer size,@RequestParam(defaultValue = "0") Integer status){
        return null;
    }

}
