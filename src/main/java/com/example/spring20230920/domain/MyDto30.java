package com.example.spring20230920.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDto30 {
    private  String keyword;

    public String getKeyword() {
        if(keyword==null){
            return "%%";
        }
        return "%"+keyword+"%";
    }
}
