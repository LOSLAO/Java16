package com.bit.demo2;


 class Shape{
    public void Draw() {

    }
}
class Circle extends Shape {
    @Override
    public void Draw() {
        System.out.println("这是一个圆！");
    }
}
class Rect extends Shape {
    @Override
    public void Draw() {
        System.out.println("这是一个矩形!");
    }
}
class Flowers extends Shape {
    @Override
    public void Draw() {
        System.out.println("这是一朵花!");
    }
}
public class TestDemo {
    public static void drawMap(Shape shape) {
        shape.Draw();
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Rect(), new Flowers()};
        for (Shape shape: shapes) {
            shape.Draw();
        }

    }
    public static void main1(String[] args) {
        Shape shape1 = new Circle();
        //shape1.Draw();

        Shape shape2 = new Rect();
        //shape2.Draw();
        drawMap(shape1);
        drawMap(shape2);
        Shape shape3 = new Flowers();
        drawMap(shape3);
    }
}
