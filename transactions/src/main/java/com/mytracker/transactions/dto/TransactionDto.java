package com.mytracker.transactions.dto;

import com.mytracker.transactions.entity.enums.Category;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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

    @Size(min = 3, max = 30, message = "The length of the first name should be between 3 and 30")
    private String username;

    private Category category;

    @Size(min = 3, max = 30, message = "The length of the description should be between 3 and 30")
    private String description;

    @PositiveOrZero
    private Integer amount;

    @PastOrPresent(message = "Transaction time must not be in future")
    private LocalDateTime time;
}