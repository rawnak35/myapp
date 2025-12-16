package com.mytracker.transactions.service.impl;

import com.mytracker.transactions.dto.TransactionDto;
import com.mytracker.transactions.dto.ValueCountDto;
import com.mytracker.transactions.entity.Transaction;
import com.mytracker.transactions.entity.enums.Category;
import com.mytracker.transactions.exception.ResourceNotFoundException;
import com.mytracker.transactions.mapper.TransactionMapper;
import com.mytracker.transactions.repository.TransactionRepository;
import com.mytracker.transactions.service.TransactionsService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {

    private TransactionRepository transactionsRepository;

    @Override
    public TransactionDto createTrans(TransactionDto transDto) {
        Transaction savedTrans = transactionsRepository.save(TransactionMapper.mapToTransaction(transDto));
        return TransactionMapper.mapToTransactionDto(savedTrans);
    }

    @Override
    public TransactionDto getById(Long id) {
        Transaction transaction = transactionsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id.toString()));
        return TransactionMapper.mapToTransactionDto(transaction);
    }

    @Override
    public List<TransactionDto> getByUsername(String username) {
        List<Transaction> transaction = transactionsRepository.findByUserId(username);
        return transaction.stream().map(TransactionMapper::mapToTransactionDto).toList();
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return transactionsRepository.findAll().stream().map(TransactionMapper::mapToTransactionDto).toList();
    }

    @Override
    public TransactionDto updateTransaction(Long id, TransactionDto updatedTrans) {
        Transaction transaction = transactionsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id.toString()));
        transaction.setAmount(updatedTrans.getAmount());
        transaction.setCategory(updatedTrans.getCategory());
        transaction.setTime(updatedTrans.getTime());
        transaction.setDescription(updatedTrans.getDescription());
        Transaction savedTran = transactionsRepository.save(transaction);
        return TransactionMapper.mapToTransactionDto(savedTran);
    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction transaction = transactionsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction", "id", id.toString()));
        transactionsRepository.delete(transaction);
    }

    @Override
    public List<TransactionDto> getByCategory(Category category) {
        List<Transaction> transactions = transactionsRepository.findByCategory(category);
        return transactions.stream().map(TransactionMapper::mapToTransactionDto).toList();
    }

    @Override
    public List<ValueCountDto> getCategoriesTotalAmount() {
        return transactionsRepository.groupByCategory();
    }
}
