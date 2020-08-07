package com.bit.Demo5;



class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}

interface IFlying {
    void fly();
}
interface IRunning {
    void run();
}
interface ISwimming {
    void swim();
}

//1.一个类可以继承一个普通类/抽象类，并且可以同时实现多个接口
//先是extends,再是implements
class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在跑");
    }
}

class Fish extends Animal implements ISwimming {
    public Fish(String name) {
        super(name);
    }
    @Override
    public void swim() {
        System.out.println(this.name + "正在用尾巴游泳");
    }
}

class Frog extends Animal implements IRunning, ISwimming {
    public Frog(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在往前跳");
    }
    @Override
    public void swim() {
        System.out.println(this.name + "正在蹬腿游泳");
    }
}

class Robot implements IRunning {
    @Override
    public void run() {
        System.out.println("我是机器人，我先跑了");
    }
}
public class TestDemo2 {
    public static void walk(IRunning running) {
        System.out.println("我带着伙伴去散步");
    }
    public static void main(String[] args) {

        IRunning iRunning1 = new Robot();
        iRunning1.run();
        Frog frog = new Frog("wawa");
        walk(frog);
        IRunning iRunning2 = new Frog("wawa");
        walk(iRunning2);
    }
}
