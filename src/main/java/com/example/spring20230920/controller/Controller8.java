package com.example.spring20230920.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("main8")
public class Controller8 {

    @RequestMapping("sub1")
    public  void method1(Model model){
        model.addAttribute("attr1","value1");
        model.addAttribute("attr2","value2");
    }


    @RequestMapping("sub2")
    public void method(Model model){
        model.addAttribute("propone","👍👍👍");
        model.addAttribute("propTWO","😒😒😒");
    }
}
