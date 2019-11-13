package com.lz.bitcoinexplorer1113.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    @RequestMapping("/{search}")
    public String search(@PathVariable String search){
        return null;
    }
}
