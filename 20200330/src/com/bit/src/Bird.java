package com.bit.src;


public class Bird extends Animal {
    public int age;
    //构造父类
    public Bird(String name,int age) {
        //构造父类  //代表调用父类的带有一个参数的构造方法 只能调用一次 放在第一行
        super(name);//子类并没有继承父类的构造方法 只是在子类当中 进行了显示的调用 通过super
        this.age = age;
    }

    public void fly() {
        System.out.println(this.name+" 正在飞! ");
        System.out.println(super.name);
        super.eat();
    }

    public void testProtected() {

        System.out.println(this.sex);
    }
    //public String name;
    /*public void eat() {
        System.out.println(this.name+" 正在吃！");
    }*/
}
