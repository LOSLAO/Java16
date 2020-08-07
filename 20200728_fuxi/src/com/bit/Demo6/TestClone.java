package com.bit.Demo6;

class Money implements Cloneable{
    double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    public int age;

    Money m = new Money();

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        //1.克隆当前的Money对象
        Person p = (Person)super.clone();
        //2.克隆当前的Money对象
        p.m = (Money) this.m.clone();
        return p;
    }
}

public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        Person person2 = (Person) person1.clone();
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
        person2.m.money = 99.9;
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        Person person2 = (Person)person1.clone();
        System.out.println(person1.age);
        System.out.println(person2.age);
        person2.age = 99;
        System.out.println(person1.age);
        System.out.println(person2.age);
    }
}
