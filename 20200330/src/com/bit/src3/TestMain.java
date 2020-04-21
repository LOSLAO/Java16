package com.bit.src3;


class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
        //eat();
    }

     public void eat() {
        System.out.println("Animal:" + this.name+ " 正在吃! ");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(this.name+ " 正在飞! ");
    }

    public void eat() {
        System.out.println("Bird:" + this.name+ " 正在吃米! ");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}


public class TestMain {

    //面试问题:构造函数中是否可以发生运行时绑定
    public static void main(String[] args) {
        Animal animal = new Animal("将军");
        System.out.println();
        Animal bird = new Bird("将军2");
    }

    //演示向下转型不安全实列
    public static void main3(String[] args) {
        Animal animal = new Cat("汤姆");
        //此时animal并不是Bird的一个实例
        if(animal instanceof Bird) {
            Bird bird = (Bird) animal;
            bird.fly();
        }
    }

    public static void main2(String[] args) {
        Animal animal = new Bird("将军");
        animal.eat();

        Bird bird = (Bird) animal;//向下转型

        bird.fly();
    }

    public static void main1(String[] args) {
        Animal animal = new Bird("将军");
        animal.eat();
    }

    /*public static void func1(Animal animal) {
        animal.eat();
    }

    public Animal func2() {
        Bird bird = new Bird("喜鹊");
        return bird;
    }

    public static void main3(String[] args) {
        Bird bird = new Bird("凤儿");
        func1(bird);
    }


    public static void main2(String[] args) {
        //父类引用 引用了子类对象 ==> 向上转型
        Animal animal = new Bird("凤儿");
        animal.eat();
        //animal.fly();//父类引用 只能访问自己的成员方法或者属性
    }
    public static void main1(String[] args) {
        Animal animal = new Animal("将军");

        Bird bird = new Bird("凤儿");

        Cat cat = new Cat("汤姆");


    }*/
}
