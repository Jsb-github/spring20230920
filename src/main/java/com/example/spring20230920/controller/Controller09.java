package com.example.spring20230920.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main9")
public class Controller09 {
    @RequestMapping("sub1")
    public void method1(Model model){
        model.addAttribute("attr1","son");
        model.addAttribute("attr2",300);
        model.addAttribute("attr3",true);
        model.addAttribute("attr4",3.14);

        //모델속성이 배열일 경 우

        model.addAttribute("attr5",new String[]{"lee","kim"});

        String [] myArr1 = {"korea","seoul","jeju"};
        model.addAttribute("yourArr6",myArr1);

    }


    @RequestMapping("sub2")
    public void method2(Model model){
        String [] myArr1 = {"손흥민","이강인","김민재"};
        String [] myArr2 = {"aaa@aaa.com","bbb@bbb.com","ccc@ccc.com"};
        String [] myArr3 = {"서울","제주","부산"};

        model.addAttribute("myName",myArr1);
        model.addAttribute("yourEmail",myArr2);
        model.addAttribute("herAddress",myArr3);

    }

    @RequestMapping("sub3")
    public void method3(Model model){
        model.addAttribute("names", List.of("두식","봉석","희수"));

        List<String> list1 = List.of("축구","야구","농구");
        List<String> list2 = List.of("이강인","이정후","조던");
        List<String> list3 = List.of("1","2","3");

        model.addAttribute("list1",list1);
        model.addAttribute("mapList",list2);
        model.addAttribute("cities",list3);


    }



}
