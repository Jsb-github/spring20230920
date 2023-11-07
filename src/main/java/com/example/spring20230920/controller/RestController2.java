package com.example.spring20230920.controller;


import com.example.spring20230920.dao.MyDao10;
import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.MyDto34Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/main2")
public class RestController2 {

    private final MyDao10 dao;


    @GetMapping("sub1")
    @ResponseBody
    public String method1() {
        return  dao.getCustomerName();
    }

    @GetMapping("sub2")
    @ResponseBody
    public  MyDto34Customer method3(){
        return dao.getCustomer();
    }
}
