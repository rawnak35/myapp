package com.mytracker.transactions.mapper;

import com.mytracker.transactions.dto.TransactionDto;
import com.mytracker.transactions.entity.Transaction;

public class TransactionMapper {

    public static TransactionDto mapToTransactionDto(Transaction trans){
        return new TransactionDto(trans.getId(), trans.getUserId(),trans.getCategory(), trans.getDescription(), trans.getAmount(), trans.getTime());
    }

    public static Transaction mapToTransaction(TransactionDto transDto){
        return new Transaction(transDto.getId(), transDto.getUsername(), transDto.getCategory(), transDto.getDescription(), transDto.getAmount(), transDto.getTime());
    }
}
