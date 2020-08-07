package com.bit.Demo5;
//接口（Interface)
//注意事项
//1.接口当中的方法都是抽象方法
//2.其实可以有具体实现的方法 这个方法是被default修饰的（JDK1.8加入的）
//3.接口当中定义的成员变量，默认是常量
//4.接口当中的成员变量默认是public static final
//成员方法是：public abstract
//5.接口是不能被实例化的
//6.接口和类之间的关系：implements
//7.为了解决Java单继承的问题,可以实现多个接口
//8.只要这个类实现了该接口，那么你就可以进行向上转型了


interface Shape {
    //public static final int a = 10;
    //public abstract void draw();
    //    public void func1() {
//
//    }
//    default void func() {
//        System.out.println("ssdadada");
//    }
    void draw();
}
class Cycle implements Shape {
    @Override
    public void draw() {
        System.out.println("画一个圆");
    }
}

class React implements Shape {
    @Override
    public void draw() {
        System.out.println("画一个矩形");
    }
}

public class TestDemo1 {
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
