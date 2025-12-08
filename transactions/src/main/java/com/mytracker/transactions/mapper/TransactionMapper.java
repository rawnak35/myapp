package com.mytracker.transactions.mapper;

import com.mytracker.transactions.dto.TransactionDto;
import com.mytracker.transactions.entity.Transaction;
import com.mytracker.transactions.entity.User;

public class TransactionMapper {

    public static TransactionDto mapToTransactionDto(Transaction trans){
        return new TransactionDto(trans.getId(), trans.getUser().getUsername(), trans.getCategory(), trans.getDescription(), trans.getAmount(), trans.getTime());
    }

    public static Transaction mapToTransaction(TransactionDto transDto, String user_id){
        return new Transaction(transDto.getId(), user_id, transDto.getCategory(), transDto.getDescription(), transDto.getAmount(), transDto.getTime());
    }
}
