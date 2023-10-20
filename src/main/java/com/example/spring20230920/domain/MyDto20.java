package com.example.spring20230920.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyDto20 {
    private String productName;
    private Double price;
    private String categoryName;
}
