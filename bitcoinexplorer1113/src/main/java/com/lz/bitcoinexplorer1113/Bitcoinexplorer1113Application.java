package com.lz.bitcoinexplorer1113;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lz.bitcoinexplorer.dao")
public class Bitcoinexplorer1113Application {

    public static void main(String[] args) {
        SpringApplication.run(Bitcoinexplorer1113Application.class, args);
    }

}
