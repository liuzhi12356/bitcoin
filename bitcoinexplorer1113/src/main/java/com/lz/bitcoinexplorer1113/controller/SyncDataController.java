package com.lz.bitcoinexplorer1113.controller;

import com.lz.bitcoinexplorer1113.service.BlockService;
import com.lz.bitcoinexplorer1113.service.SyncDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/syncdata")
@EnableAutoConfiguration
public class SyncDataController {
    @Autowired
    private BlockService blockService;
    @Autowired
    private SyncDataService syncDataService;

    @PostMapping("/fullImport")
    public void fullImport(@RequestParam(required = false, defaultValue = "000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943") String blockhash){
        syncDataService.syncBlocks(blockhash);
    }


}
