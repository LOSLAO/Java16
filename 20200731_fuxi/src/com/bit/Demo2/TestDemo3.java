package com.bit.Demo2;
//字符串查找
public class TestDemo3 {
    public static void main4(String[] args) {
        //字符串以特定的子串开头/结尾
        String str = "hello world";
        System.out.println(str.startsWith("h"));
        System.out.println(str.endsWith("d"));
    }
    public static void main3(String[] args) {
        String str1 = "hello world";
        String str2 = "l";
        System.out.println(str1.lastIndexOf(str2));
    }
    public static void main2(String[] args) {
        //不光能判定是否是子串，还能判定出子串所在的位置
        String str1 = "hello world";
        String str2 = "wor";
        //如果打印出-1说明不是子串
        System.out.println(str1.indexOf(str2));

    }
    public static void main1(String[] args) {
        //判定字符串子串
        String str1 = "hello world";
        String str2 = "wor";
        System.out.println(str1.contains(str2));
    }
}
