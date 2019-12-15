package com.lz.bitcoinexplorer1113.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    @RequestMapping("/{search}")
    public String search(@PathVariable String search) {











        if (search.startsWith("000")) {
            return "block";
        } else if (search.length() < 64) {
            return "address";
        } else if (!search.startsWith("000") && search.length() == 64) {
            return "transaction";
        } else {
            return "error";
        }


    }
}