package com.lz.bitcoinexplorer1113.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.bitcoinexplorer1113.client.RestBitcoinClient;
import com.lz.bitcoinexplorer1113.dao.BlockMapper;
import com.lz.bitcoinexplorer1113.dto.AddressDto;
import com.lz.bitcoinexplorer1113.po.Block;
import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.service.BlockService;
import com.lz.bitcoinexplorer1113.service.TranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/btc")
@RestController
@CrossOrigin
@EnableAutoConfiguration
public class BlockController {
    @Autowired
    private BlockService blockService;
    @Autowired
    private TranscationService transcationService;


    @MessageMapping("/blocks")
    @SendTo("/bitcoin/blocks")
    public List<Block> getBlockByHash(){
        List<Block> getblocks = blockService.getblocks();
        return getblocks;
    }

    @RequestMapping("/blocks/{page}")
    public PageInfo<Block> getBlocksByPage(@PathVariable Integer page){
        PageHelper.startPage(page,50);
        List<Block> blocks = blockService.getblocksByPage();
        PageInfo<Block> blockPageInfo = new PageInfo<>(blocks);
        return blockPageInfo;
    }
    @GetMapping("block/{height}/{page}")
    public JSONObject getBlockByHeight(@RequestParam Integer height,@PathVariable Integer page){
        return null;
    }
    @RequestMapping("/block/{hash}/{page}")
    public Block getBlocks(@PathVariable String hash,@PathVariable Integer page){
        return null;
    }

    @RequestMapping("/address/{address}")
    public AddressDto getinfoByAddress(@PathVariable String address){
        AddressDto address1 = transcationService.address(address);
        List<Transaction> transactions = transcationService.gettxByaddress(address);
        address1.setTransactions(transactions);

        return address1;
    }
}
