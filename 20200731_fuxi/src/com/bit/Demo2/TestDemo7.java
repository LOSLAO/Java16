package com.bit.Demo2;
//其他操作方法
public class TestDemo7 {
    public static void main(String[] args) {
        String str1 = "";
        System.out.println(str1.isEmpty());
        String str2 = null;
        System.out.println(str2.isEmpty());
    }
    public static void main2(String[] args) {
        String str = "HeLlo";
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        //首字母大写，其余小写
        String result = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        System.out.println(result);
    }
    public static void main1(String[] args) {
        String str = "       hello   world     ";
        System.out.println(str.trim());
    }
}
