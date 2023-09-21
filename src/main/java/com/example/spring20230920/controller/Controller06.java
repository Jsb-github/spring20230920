package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto3;
import com.example.spring20230920.domain.MyDto4;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("main6")
public class Controller06 {

    @RequestMapping("sub1")
    public  void method1(MyDto3 obj){
        System.out.println("obj = " + obj);
    }


    //main6/sub2?signed=true&email=ab@gamil.com&gender=male
    @RequestMapping("sub2")
    public  void method2(MyDto4 obj){
        System.out.println("obj = " + obj);
    }
}
