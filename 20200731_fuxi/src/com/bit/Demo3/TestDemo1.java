package com.bit.Demo3;
//StringBuffer 和 StringBuilder
public class TestDemo1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcd");
        sb.delete(1, 2);
        System.out.println(sb);

        String str = "abcd";
        String result = str.substring(0, 1) + str.substring(2);
        System.out.println(result);
    }
    public static void main4(String[] args) {
        //插入删除操作
        StringBuilder sb = new StringBuilder("abcd");
        sb.insert(1, "haha");
        System.out.println(sb);

        String str = "abcd";
        String result = str.substring(0,1) + "haha" + str.substring(1);
        System.out.println(result);
    }
    public static void main3(String[] args) {
        //字符串反转
        StringBuilder sb = new StringBuilder("abcd");
        sb.reverse();
        System.out.println(sb);

    }
    public static void main2(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello").append("x").append("x").append("x").append("x").append("x");
        System.out.println(sb);
    }
    public static void main1(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append("x");
        sb.append("x");
        sb.append("x");
        sb.append("x");
        sb.append("x");
        System.out.println(sb);
    }


}
