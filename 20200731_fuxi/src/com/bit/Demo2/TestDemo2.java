package com.bit.Demo2;

public class TestDemo2 {
    public static void main(String[] args) {
        String str1 = "HaHa";
        String str2 = "haha";
        System.out.println(str1.equalsIgnoreCase(str2));
    }
    public static void main2(String[] args) {
        //字符串比较（比较大小）
        String str1 = "Haha";
        String str2 = "haha";
        //compareTo是Comparable接口中提供的抽象方法
        //compareTo 返回值>0，认为str1比str2大
        //compareTo 返回值<0,认为str1比str2小
        //compareTo 返回值==0，认为str1和str2相等
        System.out.println(str1.compareTo(str2));
    }
    public static void main1(String[] args) {
        //字符串转换成字节数组
        String str = "hello";
        byte[] array = str.getBytes();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        String string = new String(array);
        System.out.print(string);
    }
}
