package com.bit.Demo1;


class Base {
    public int a;
}

class Derive extends Base {
    public int b;
}
public class TestDemo2 {
    public static void main(String[] args) {
        Derive derive = new Derive();
        derive.a = 99;
    }
}
