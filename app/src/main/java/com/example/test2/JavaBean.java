package com.example.test2;

public class JavaBean {

    int number;

    int amount;

    public JavaBean() {
    }

    public JavaBean(int number, int amount) {
        this.number = number;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
