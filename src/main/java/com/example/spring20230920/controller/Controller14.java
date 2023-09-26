package com.example.spring20230920.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("main14")
public class Controller14 {


    @GetMapping({"sub1","sub3"})
    public void method1(){

    }

    @GetMapping ("sub2")
    public void method2(
            @RequestParam("id") String id,
            @RequestParam("password") String password
    ){
        System.out.println("id = " + id);
        System.out.println("password = " + password);
    }
//    @RequestMapping(value = "Sub2" , method = RequestMethod.POST)
   @PostMapping("sub2")
    public void method3(
            @RequestParam("id") String id,
            @RequestParam("password") String password
    ){
        System.out.println("id = " + id);
        System.out.println("password = " + password);
    }

   @PostMapping("sub4")
    public void method4(
            String title,
            String content
    ){
        System.out.println("title = " + title);
        System.out.println("content = " + content);

    }
    //아래 두 RequstMapping 어노테이션을 줄여서 작성
    // sub5.jsp에 적절한 form 요소코드 작성해서
    // 전송시 method6이 실행 될수 있도록
    @GetMapping(value = "sub5")
    public void methid5(){}

//    @RequestMapping(value = "sub6",method = RequestMethod.POST)?\
    @PostMapping("sub6")
    public void method6(
            String username,
            String password
    ){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
