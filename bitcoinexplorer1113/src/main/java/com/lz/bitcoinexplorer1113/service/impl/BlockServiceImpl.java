package com.lz.bitcoinexplorer1113.service.impl;

import com.lz.bitcoinexplorer1113.po.Block;
import com.lz.bitcoinexplorer1113.service.BlockService;
import org.springframework.stereotype.Service;
@Service
public class BlockServiceImpl implements BlockService {

    @Override
    public int deleteByPrimaryKey(Integer blockId) {
        return 0;
    }

    @Override
    public int insert(Block record) {
        return 0;
    }

    @Override
    public int insertSelective(Block record) {
        return 0;
    }

    @Override
    public Block selectByPrimaryKey(Integer blockId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Block record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Block record) {
        return 0;
    }

    @Override
    public Block selectByHeight(Integer height) {
        return null;
    }

    @Override
    public void truncate() {

    }
}
