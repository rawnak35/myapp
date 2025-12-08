package com.mytracker.transactions.dto;

import com.mytracker.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValueCountDto {
    private Category category;
    private Long total;
}
