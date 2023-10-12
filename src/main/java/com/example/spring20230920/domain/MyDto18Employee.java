package com.example.spring20230920.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDto18Employee {

    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String photo;
    private String notes;
}
