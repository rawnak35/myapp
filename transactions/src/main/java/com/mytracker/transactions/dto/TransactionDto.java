package com.mytracker.transactions.dto;

import com.mytracker.transactions.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    private String username;
    private Category category;
    private String description;
    private Integer amount;
    private LocalDateTime time;
}