package com.example.spring20230920;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApp6 {
    public static void main(String[] args) {
        // inversion of Control (IOC)
        // IOC Container
      ApplicationContext context = SpringApplication.run(MyApp6.class, args);

        MyClass9 myClass9 = context.getBean("myClass9", MyClass9.class);
        myClass9.method9();

        System.out.println("myClass9 = " + myClass9.getFiled1());
        Object myClass10 = context.getBean("myClass10");
        System.out.println("myClass10 = " + myClass10);
    }
}


@Component
class MyClass10{
    public void method10(){
        System.out.println("MyClass10.method10");
    }
}

@Component
class MyClass9{
    private MyClass10 filed1; //dependency

    public MyClass9() {
    }

    public MyClass9(MyClass10 filed1) {
        this.filed1 = filed1;
    }

    @Autowired // dependency inject(DI, 의존성 주입)
    public void setFiled1(MyClass10 filed1) {
        this.filed1 = filed1;
    }

    public MyClass10 getFiled1() {
        return filed1;
    }

    public void method9(){
        filed1.method10();
    }
}