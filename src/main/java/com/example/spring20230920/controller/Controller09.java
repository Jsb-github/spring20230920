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
    public void method3(Model model) {
        model.addAttribute("names", List.of("두식", "봉석", "희수"));

        var list1 = List.of("무빙", "엘리멘탈");
        model.addAttribute("list1", list1);

        var list2 = List.of("korea", "us", "japan");
        model.addAttribute("mapList1", list2);

        var list3 = List.of("seoul", "jeju", "busan", "incheon");
        model.addAttribute("cities", list3);
    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        var map1 = Map.of("son", 7, "lee", 19, "kim", 30);

        model.addAttribute("myMap", map1);

        var map2 = Map.of("seoul", "특별시", "busan", "광역시");

        model.addAttribute("cityMap", map2);
        model.addAttribute("color", Map.of(
                "red", "#ff0000",
                "blue", "#0000ff",
                "black", "#000000"
        ));

        var map3 = Map.of(
                "name", "두식",
                "my name", "봉석",
                "your-name", "희수"
        );
        model.addAttribute("attr3", map3);

    }



}
