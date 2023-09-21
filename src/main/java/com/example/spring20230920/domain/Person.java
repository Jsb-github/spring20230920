package com.example.spring20230920.domain;

public class Person {
    // name property(읽기,쓰기)
    // age property(읽기, 쓰기)
    // address property(읽기, 쓰기)

    private  String name;
    private  Integer age;
    private String ddress;

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDdress() {
        return ddress;
    }

    public void setDdress(String ddress) {
        this.ddress = ddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ddress='" + ddress + '\'' +
                '}';
    }
}
