package com.lz.bitcoinexplorer1113.service;

import com.lz.bitcoinexplorer1113.po.Block;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BlockService {
    int deleteByPrimaryKey(Integer blockId);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(Integer blockId);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    Block selectByHeight(Integer height);
    void truncate();

}
