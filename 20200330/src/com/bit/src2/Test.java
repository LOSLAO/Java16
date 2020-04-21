package com.bit.src2;

import com.bit.src.Animal;

public class Test extends Animal{


    public Test(String name) {
        super(name);
    }

    public void func() {
        System.out.println(super.name);
    }

    public static void main1(String[] args) {
        Animal animal = new Animal("杰克");
        //System.out.println(animal.sex);
    }

}
