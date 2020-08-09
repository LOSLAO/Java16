package com.bit.Demo1;
//认识String类
public class TestDemo1 {
    public static void main(String[] args) {
        String str = "Hello";
        str = "h" + str.substring(1);
        System.out.println(str);
    }
    public static void main5(String[] args) {
        String str1 = "haha";
        str1 = "hehe";
        System.out.println(str1);
    }
    public static void main4(String[] args) {
        String str1 = "hehe";
        String str2 = new String("hehe").intern();
        System.out.println(str1 == str2);
    }
    public static void main3(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        System.out.println(str1.equals(str2));
    }
    public static void main2(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        System.out.println(str1 == str2);
    }
    public static void main1(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1 == str2);
    }
}
