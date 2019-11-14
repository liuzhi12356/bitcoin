package com.lz.bitcoinexplorer1113.dao;

import com.lz.bitcoinexplorer1113.po.Block;
import org.apache.ibatis.annotations.Mapper;

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
}