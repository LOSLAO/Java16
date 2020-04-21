package com.bit.src;


public class Animal {
    public String name;

    protected String sex;



    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(this.name+" 正在吃！");
    }
}
