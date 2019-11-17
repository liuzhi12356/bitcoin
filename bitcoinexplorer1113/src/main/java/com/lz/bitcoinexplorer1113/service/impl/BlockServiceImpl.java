package com.lz.bitcoinexplorer1113.service.impl;

import com.lz.bitcoinexplorer1113.dao.BlockMapper;
import com.lz.bitcoinexplorer1113.dto.BlockDto;
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
        return blockMapper.deleteByPrimaryKey(blockId);
    }

    @Override
    public int insert(Block record) {
        return blockMapper.insert(record);
    }

    @Override
    public int insertSelective(Block record) {
        return blockMapper.insertSelective(record);
    }

    @Override
    public Block selectByPrimaryKey(Integer blockId) {
        return blockMapper.selectByPrimaryKey(blockId);
    }

    @Override
    public int updateByPrimaryKeySelective(Block record) {
        return blockMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Block record) {
        return blockMapper.updateByPrimaryKey(record);
    }

    @Override
    public Block selectByHeight(Integer height) {
        return blockMapper.selectByHeight(height);
    }

    @Override
    public void truncate() {
     blockMapper.truncate();
    }

    @Override
    public List<Block> getblocks() {
        return blockMapper.getblocks();
    }

    @Override
    public List<Block> getblocksByPage() {
        return blockMapper.getblocksByPage();
    }

    @Override
    public BlockDto getblockByHeight(Integer height) {
        return blockMapper.getblockByHeight(height);
    }

    @Override
    public BlockDto getblockByhash(String hash) {

        return blockMapper.getblockByhash(hash);
    }
}
