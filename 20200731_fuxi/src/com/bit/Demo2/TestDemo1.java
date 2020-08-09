package com.bit.Demo2;

public class TestDemo1 {
    public static void main(String[] args) {
        // 给定字符串一个字符串, 判断其是否全部由数字所组成.
        String str = "1a23456";
        System.out.println(IsNumber(str));
    }
    public static boolean IsNumber(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < '0' || array[i] > '9') {
                return false;
            }
        }
        return true;
    }
    public static void main3(String[] args) {
        //字符数组=>字符串
        char[] array = {'a', 'b', 'c'};
        String str = new String(array);
        System.out.println(str);
    }
    public static void main2(String[] args) {
        //字符串和字符数组之间的相互转换
        String str = "Hello";
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        //此时修改array的内容是否会影响到str的内容呢
        array[0] = 'h';
        System.out.println(str);
        //改变不了，说明toCharArray是把String中包含的字符数组给拷贝了一份
    }
    public static void main1(String[] args) {
        //获取到这个字符串中的某个字符
        String str = "Hello";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }
}
