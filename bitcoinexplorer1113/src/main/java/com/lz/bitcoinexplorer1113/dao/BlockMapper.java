package com.lz.bitcoinexplorer1113.dao;

import com.lz.bitcoinexplorer1113.dto.BlockDto;
import com.lz.bitcoinexplorer1113.po.Block;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlockMapper {
    int deleteByPrimaryKey(Integer blockId);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(Integer blockId);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    Block selectByHeight(Integer height);
    void truncate();

    List<Block> getblocks();
    List<Block> getblocksByPage();

    BlockDto getblockByHeight(Integer height);
    BlockDto getblockByhash(String hash);
}