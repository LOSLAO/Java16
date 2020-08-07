package com.bit.Demo1;


class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal(String)");
    }

    public void eat() {
        System.out.println(this.name + "正在吃");
    }

    public void sleep() {
        System.out.println("Animal::sleep()");
    }
}

class Cat extends Animal{
    public Cat(String name) {
        super(name);
        System.out.println("Cat(String)");
    }
//    public String name;
//
//    public void eat() {
//        System.out.println(this.name + "正在吃");
//    }
}

class ChineseGardenCat extends Cat {

    public ChineseGardenCat(String name) {
        super(name);
    }
}



class Bird {
    public String name;

    public void eat() {
        System.out.println(this.name + "正在吃");
    }

    public void fly() {
        System.out.println(this.name + "正在飞");
    }
}



public class TestDemo1 {
    public static void main(String[] args) {
        ChineseGardenCat chineseGardenCat = new ChineseGardenCat("xixi");
        chineseGardenCat.eat();
    }
    public static void main1(String[] args) {
        Cat cat = new Cat("haha");
        //cat.name = "haha";
        cat.eat();
    }
}
