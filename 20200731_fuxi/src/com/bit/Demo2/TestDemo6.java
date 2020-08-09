package com.bit.Demo2;
//字符串截取
public class TestDemo6 {
    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(str.substring(5));
        //打印的范围为前闭后开区间
        System.out.println(str.substring(5, 7));
    }
}
