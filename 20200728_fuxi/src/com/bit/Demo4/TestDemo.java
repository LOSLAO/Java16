package com.bit.Demo4;
//抽象类
//1.抽象方法：一个方法如果被abstract修饰，那么这个方法就是抽象方法，抽象方法可以没有具体的实现
//2.抽象类：包含抽象方法的类
//注意事项：
//1.抽象类不可以被实例化 例如Shape shape = new Shape();
//2.类内的数据成员，和普通类没有区别
//3.抽象类主要就是用来被继承
//4.如果一个类继承了这个抽象类，那么这个类必须重写抽象类当中的抽象方法
//5.当抽象类A继承了抽象类B 那么A可以不重写B中的方法，但是一旦A要是在被继承，那么一定还要重写这个抽象类方法
//6.抽象类或者抽象方法一定是不能被final修饰的
abstract class Shape {
//    public int age;
//    private int a;
//    public void func() {
//
//    }
    public abstract void draw();
    private void func() {

    }
}

class Cycle extends Shape {
    @Override
    public void draw() {

    }
}



class React extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个矩形");
    }
}

public class TestDemo {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        Shape shape = new Cycle();
        Shape shape1 = new React();
        drawMap(shape);
        drawMap(shape1);

    }
}
