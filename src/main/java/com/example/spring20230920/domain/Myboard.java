package com.example.spring20230920.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Myboard {
    private Integer no;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime date;
}
