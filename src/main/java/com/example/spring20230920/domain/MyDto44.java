package com.example.spring20230920.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDto44 {

    private  String name;

    private  Double price;

    private Double weight;

    private Boolean married;

    private List<String> email;

    private Map<String, Object> home;

}
