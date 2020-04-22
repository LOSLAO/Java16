package com.bit.demo3;

//抽象类：包含抽象方法的类，我们把它叫做抽象类
//1.用关键字abstract进行修饰
//2.在抽象类中可以有普通类的所有属性
//3.和普通的类 不一样的地方就是 包含了抽象方法
//4.和普通的类 不一样的地方就是 他不能够被实例化
//5.抽象类的主要作用就是用来被继承的
//6.抽象类是用来被继承的 不能被final所修饰
//7.抽象方法也不能是私有的 或者是 static的
//8.只要有一个类继承了这个抽象类 那么必须要重写抽像类的方法
//9.如果这个类不想重写抽象类里面的抽象方法 那么此时这个类也可以设置为抽象类

abstract class Picture{
    public int a;
    public void func() {
        System.out.println("func()");
    }
    public abstract void Draw();//抽象方法：没有具体实现的方法

}

abstract class B extends Picture {

}
/*class C extends B{
    //这里必须要重写
}*/

class A extends Picture {
    @Override
    public void Draw() {

    }
}
class Tree extends Picture {
    @Override
    public void Draw() {
        System.out.println("这是一棵树！");
    }
}
class Stone extends Picture {
    @Override
    public void Draw() {
        System.out.println("这是一块石头!");
    }
}
class Flowers extends Picture {
    @Override
    public void Draw() {
        System.out.println("这是一朵花!");
    }
}
public class TestDemo {
    public static void drawMap(Picture picture) {
        picture.Draw();
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
