package com.bit.demo4;


//接口的注意事项：
//1.interface 关键字修饰
//2.里面的数据成员必须是一个常量
//3.里面的成员方法默认为：public abstract
//4.在接口当中 不能定义一个已经实现的方法
//5.JDK1.8新特性：接口当中可以有实现的方法 但是这个方法一定是被default修饰的
//6.类和接口的关系： 实现一个接口 implements 可以实现多个接口
//7. 解决了 Java当中 单继承的问题
//8.实现该接口 一定要重写该接口的方法
//9.接口仍然不能被实例化
//10.实现该接口的重写方法的时候 不能省略public

interface Picture {
    void draw();
    //public int a = 10;
    //default void func() {}

}

class Tree implements Picture {
    @Override
    public void draw() {
        System.out.println("这是一棵树！");
    }
}

class Flowers implements Picture {
    @Override
    public void draw() {
        System.out.println("这是一朵花!");
    }
}

class Stone implements Picture {
    @Override
    public void draw() {
        System.out.println("这是一块石头!");
    }
}

public class TestDemo {
    public static void drawMap(Picture picture) {
        picture.draw();
    }
    public static void main(String[] args) {
        Picture picture1 = new Tree();
        Picture picture2 = new Stone();
        Picture picture3 = new Flowers();

        drawMap(picture1);
        drawMap(picture2);
        drawMap(picture3);

    }
}
