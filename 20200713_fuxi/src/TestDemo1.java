


class Student {
    private String name = "LA";
    private int age = 20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;//this代表当前对象的引用
   }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show() {
       System.out.println("name: " + this.name + " age: " + this.age);
   }
}

public class TestDemo1 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("James");
        System.out.println(student.getName());
        student.setAge(18);
        System.out.println(student.getAge());
        student.show();
    }
}
