package com.bit.src;


public class TestDemo {

    public static void main3(String[] args) {
        Animal animal = new Animal("杰克");
        System.out.println(animal.sex);
    }

    public static void main(String[] args) {
        Bird bird = new Bird("凤儿",10);
        //bird.name = "凤儿";
        bird.eat();
        bird.fly();
    }

    public static void main1(String[] args) {
        Dog dog = new Dog("将军");
        //dog.name = "将军";
        dog.eat();
    }
}
