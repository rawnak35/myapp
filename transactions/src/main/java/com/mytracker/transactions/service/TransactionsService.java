package com.mytracker.transactions.service;


import com.mytracker.transactions.dto.TransactionDto;
import com.mytracker.transactions.dto.ValueCountDto;
import com.mytracker.transactions.entity.enums.Category;

import java.util.List;

public interface TransactionsService {
    TransactionDto createTrans(TransactionDto transDto);
    TransactionDto getById(Long id);
    List<TransactionDto> getByUsername(String username);
    List<TransactionDto> getAllTransactions();
    TransactionDto updateTransaction(Long id, TransactionDto updatedTrans);
    void deleteTransaction(Long id);
    List<TransactionDto> getByCategory(Category category);
    List<ValueCountDto> getCategoriesTotalAmount();
}
