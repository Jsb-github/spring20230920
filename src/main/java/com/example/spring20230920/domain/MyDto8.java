package com.example.spring20230920.domain;

public class MyDto8 {
    private String food;
    private String computer;

    private String birthDate;

    public MyDto8() {
    }

    public MyDto8(String food, String computer, String birthDate) {
        this.food = food;
        this.computer = computer;
        this.birthDate = birthDate;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "MtDto8{" +
                "food='" + food + '\'' +
                ", computer='" + computer + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
