package com.bit.demo5;

import java.util.Arrays;

class Student implements Comparable<Student> {
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        /*if(this.age < o.age) {
            return -1;
        }
        if(this.age == o.age) {
            return 0;
        }
        return 1;*/
        //return this.age - o.age;
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}




public class TestDemo2 {

    //对自定义类型进行比较  implements Comparable
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("kobe",19,100);
        students[1] = new Student("james",21,99);
        students[2] = new Student("curry", 18,98);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
