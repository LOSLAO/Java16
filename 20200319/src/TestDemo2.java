import java.util.jar.JarOutputStream;

class Student {
    private String name;
    private int age;

    //构造方法 没有返回值
    public Student() {

        this("bit",18);
        System.out.println("Student()");
    }
    public Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,int)");

    }
    /*public static void func() {
        this.name = "bit";
    }*/



    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

}
public class TestDemo2 {

    public static void main(String[] args) {
        //Student student = new Student("Kris",18);
        //System.out.println(student.getName());
        Student student2 = new Student();
        System.out.println(student2.getName());
        System.out.println(student2.getAge());

    }

    public static void main1(String[] args) {
        Student student = new Student();
        student.setAge(99);
        System.out.println(student.getAge());
        student.setName("caocao");
        System.out.println(student.getName());

    }


}
