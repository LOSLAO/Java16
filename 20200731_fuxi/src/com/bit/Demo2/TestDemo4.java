package com.bit.Demo2;
//字符串替换
public class TestDemo4 {
    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(str.replaceFirst("l", "-"));
    }
    public static void main1(String[] args) {
        String str = "hello world";
        System.out.println(str.replaceAll("l", "-"));
        //替换没有修改源字符串的内容，而是生成了一个替换后的字符串，字符串是不可变对象
        System.out.println(str);
    }
}
