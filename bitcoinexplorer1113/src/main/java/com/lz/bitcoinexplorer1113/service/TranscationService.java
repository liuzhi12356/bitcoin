package com.lz.bitcoinexplorer1113.service;

import com.lz.bitcoinexplorer1113.dto.AddressDto;
import com.lz.bitcoinexplorer1113.dto.TransactionDto;
import com.lz.bitcoinexplorer1113.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TranscationService {
    int deleteByPrimaryKey(Integer transactionId);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer transactionId);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
    void truncate();
    public List<Transaction> getuntxs();

    AddressDto address(@Param("address") String address);
    List<TransactionDto> gettxByaddress(@Param("address") String address);

    List<TransactionDto> gettransacionsByBlockId(Integer blockId);

    TransactionDto gettxByhash(String hash);
    public List<Transaction> untxs();
}
