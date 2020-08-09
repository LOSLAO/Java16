package com.bit.Demo2;
//字符串拆分
public class TestDemo5 {
    public static void main(String[] args) {
        String str = "192.168.1.0";
        //.在正则表达式中，是一种特殊符号，为了让spilt能够识别出源字符串中的.
        //需要进行转义，用两个\\ 一个是Java中进行转义，一个是在正则表达式转义
        String[] result = str.split("\\.");
        for (String x: result) {
            System.out.println(x);
        }
    }
    public static void main2(String[] args) {
        String str = "hello:world::haha:haha";
        String[] result = str.split(":");
        for (String x: result) {
            System.out.println(x);
        }
    }
    public static void main1(String[] args) {
        String str = "hello world haha haha";
        String[] result = str.split(" ");
        for (String x: result) {
            System.out.println(x);
        }
    }

}
