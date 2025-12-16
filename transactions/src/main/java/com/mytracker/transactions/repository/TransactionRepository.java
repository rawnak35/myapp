package com.mytracker.transactions.repository;

import com.mytracker.transactions.dto.ValueCountDto;
import com.mytracker.transactions.entity.Transaction;
import com.mytracker.transactions.entity.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(String id);

    List<Transaction> findByCategory(Category category);

    @Query("SELECT new com.mytracker.transactions.dto.ValueCountDto(t.category, SUM(t.amount)) FROM Transaction t GROUP BY t.category")
    List<ValueCountDto> groupByCategory();
}
