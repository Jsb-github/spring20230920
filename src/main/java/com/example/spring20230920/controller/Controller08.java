package com.example.spring20230920.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("main8")
public class Controller08 {

    @RequestMapping("sub1")
    public  void method1(Model model){
        model.addAttribute("attr1","value1");
        model.addAttribute("attr2","value2");
    }


    @RequestMapping("sub2")
    public void method(Model model){
        String name = "java Spring";
        String [] arr = {"👍👍👍","😡😡😡","😊😊😊😊","👌👌👌👌"};
        List<String> list = new ArrayList<>();

        for(String n : arr){
            list.add(n);
        }

        model.addAttribute("propone","👍👍👍");
        model.addAttribute("propTWO",list);
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        // view name : /main8/sub3
        // /WEB-INF/jsp/main8/sub3.jsp
        model.addAttribute("myName","손흥민");
        model.addAttribute("yourAddress","런던");
        model.addAttribute("herEmail","aaa@aaa.com");

    }
}
