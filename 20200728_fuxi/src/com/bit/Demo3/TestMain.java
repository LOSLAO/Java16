package com.bit.Demo3;


class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal(String)");
    }

    public void eat() {
        System.out.println(this.name + "Animal::正在吃");
    }

    public void sleep() {
        System.out.println("Animal::sleep()");
    }
}

class Cat extends Animal {
    public int count = 99;
    public Cat(String name) {
        super(name);
        System.out.println("Cat(String)");
    }
    public void eat() {
        System.out.println(this.name + "Cat::正在吃");
    }
//    public String name;
//
//    public void eat() {
//        System.out.println(this.name + "正在吃");
//    }
}

class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }


    public void fly() {
        System.out.println(this.name + "正在飞");
    }
}
public class TestMain {

    //向下转型:父类的引用给了字类
    public static void main(String[] args) {
        Animal animal = new Bird("bage");
        animal.eat();
        Bird bird = (Bird)animal;
        bird.fly();
    }

    //多态
    public static void main5(String[] args) {
        Animal animal = new Cat("mimi");
        animal.eat();
    }
    public static  Animal func() {
        Cat cat = new Cat("mimi");
        return cat;
    }

    public static void main4(String[] args) {
        Animal animal = func();
        animal.eat();
    }
    public static void func(Animal animal) {
        animal.eat();
    }
    public static void main3(String[] args) {
        Cat cat = new Cat("mimi");
        func(cat);

    }
    public static void main2(String[] args) {
        //向上转型:父类引用引用子类对象
        Animal animal = new Cat("mimi");
        animal.eat();
       //animal.count;
    }
    public static void main1(String[] args) {
        Animal animal = new Animal("doudou");
        Cat cat = new Cat("mimi");

    }
}
