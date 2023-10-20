package com.example.spring20230920.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDto23 {
    private LocalDate date;
    private String name;
    private String categoryName;
    private Integer quantity;
    private Double price;
    private Integer categoryID;
}
