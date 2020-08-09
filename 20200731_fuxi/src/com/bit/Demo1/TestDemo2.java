package com.bit.Demo1;

import java.lang.reflect.Field;

public class TestDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "hehe";
        //Field 对象对应到某个对象中的一个具体字段
        Field field = String.class.getDeclaredField("value");
        //由于String中的value这个字符数组是private的，直接不能访问
        //先把这个数组改成可访问的
        field.setAccessible(true);
        //获取到str中的value数组的内容
        char[] value = (char[])field.get(str);
        value[1] = 'a';
        value[3] = 'a';
        System.out.println(str);
    }
}
