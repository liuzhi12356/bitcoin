package com.lz.bitcoinexplorer1113.service.impl;

import com.lz.bitcoinexplorer1113.dao.BlockMapper;
import com.lz.bitcoinexplorer1113.po.Block;
import com.lz.bitcoinexplorer1113.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

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

    @Override
    public List<Block> getblocks() {
        return blockMapper.getblocks();
    }

    @Override
    public List<Block> getblocksByPage() {
        return blockMapper.getblocksByPage();
    }
}
