package com.bit.demo1;


class Base{
    public int a;
    static {
        System.out.println("Base::static{}");
    }
    {
        System.out.println("Base::{}");
    }
    public Base(int a) {
        this.a = a;
        System.out.println("Base(int)");
    }
    public void func() {
        System.out.println("Base::func()");
    }

}

class Derive extends Base {
    public int b;
    static{
        System.out.println("Derive::static{}");
    }
    {
        System.out.println("Derive::{}");
    }
    public Derive(int a,int b) {
        super(a);
        System.out.println("Derive(int,int)");
    }

    public void func() {
        System.out.println("Derive::func()");
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Derive derive = new Derive(10,20);
        System.out.println("===============");
        Derive derive2 = new Derive(10,20);
    }
    public static void main1(String[] args) {
        Base base = new Derive(10,20);
        //向上转型 父类引用 引用子类对象
        base.func();//通过父类的引用调写重写的方法 此时会发生运行时绑定 多态
    }

}
