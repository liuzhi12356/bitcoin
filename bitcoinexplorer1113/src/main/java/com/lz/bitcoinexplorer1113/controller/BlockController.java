package com.lz.bitcoinexplorer1113.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.bitcoinexplorer1113.client.RestBitcoinClient;
import com.lz.bitcoinexplorer1113.dao.BlockMapper;
import com.lz.bitcoinexplorer1113.dto.AddressDto;
import com.lz.bitcoinexplorer1113.dto.BlockDto;
import com.lz.bitcoinexplorer1113.dto.TransactionDto;
import com.lz.bitcoinexplorer1113.po.Block;
import com.lz.bitcoinexplorer1113.po.Transaction;
import com.lz.bitcoinexplorer1113.service.BlockService;
import com.lz.bitcoinexplorer1113.service.TranscationService;
import com.lz.bitcoinexplorer1113.util.TimeFormatUtil;
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


    //@MessageMapping("/blocks")
    //@SendTo("/bitcoin/blocks")
    @RequestMapping("/blocks")
    public List<Block> getBlocks(){
        List<Block> getblocks = blockService.getblocks();
        for (Block getblock : getblocks) {
             getblock.setTimeFormat(TimeFormatUtil.timeAgo(getblock.getTime()));
             System.out.println(getblock.getTimeFormat());
        }
        return getblocks;
    }

    @RequestMapping("/blocks/{page}")
    public PageInfo<Block> getBlocksByPage(@PathVariable Integer page){
        PageHelper.startPage(page,50);
        List<Block> blocks = blockService.getblocksByPage();
        PageInfo<Block> blockPageInfo = new PageInfo<>(blocks);
        return blockPageInfo;
    }
    @GetMapping("/getblockbyheight/{height}")
    public BlockDto getBlockByHeight(@PathVariable Integer height,@RequestParam(required = false,defaultValue = "1")Integer page){
        BlockDto blockDto=blockService.getblockByHeight(height);
        Integer blockId = blockDto.getBlockId();
        blockDto.setTimeFormat(TimeFormatUtil.blocktime(blockDto.getTime()));
        PageHelper.startPage(page,10);
        List<TransactionDto> dtos=transcationService.gettransacionsByBlockId(blockId);
        PageInfo<TransactionDto> transactionDtoPageInfo = new PageInfo<>(dtos);
        blockDto.setTransactions(transactionDtoPageInfo);
        return blockDto;
    }
    @RequestMapping("/getblockbyhash/{hash}")
    public BlockDto getblockbyhash(@PathVariable String hash,@RequestParam(required = false,defaultValue = "1")Integer page){
        BlockDto blockDto=blockService.getblockByhash(hash);
        blockDto.setTimeFormat(TimeFormatUtil.blocktime(blockDto.getTime()));
        Integer blockId = blockDto.getBlockId();
        PageHelper.startPage(page,10);
        List<TransactionDto> dtos=transcationService.gettransacionsByBlockId(blockId);
        PageInfo<TransactionDto> transactionDtoPageInfo = new PageInfo<>(dtos);
        blockDto.setTransactions(transactionDtoPageInfo);
        return blockDto;
    }

    @RequestMapping("/address/{address}")
    public AddressDto getinfoByAddress(@PathVariable String address,@RequestParam(required = false,defaultValue = "1")Integer page){
        AddressDto address1 = transcationService.address(address);
        PageHelper.startPage(page,10);
        List<TransactionDto> transactions = transcationService.gettxByaddress(address);
        for (TransactionDto transaction : transactions) {
            transaction.setTimeFormat(TimeFormatUtil.nowTimes(transaction.getTime()));
        }
        PageInfo<TransactionDto> tran = new PageInfo<>(transactions);

        address1.setTransactions(tran);


        return address1;
    }
}
