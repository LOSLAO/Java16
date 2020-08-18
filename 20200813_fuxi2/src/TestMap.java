import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Student{
    public String name;
    public int age;
    public String grade;
    public String school;

    public Student(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}

public class TestMap {
    public static void main(String[] args) {
        Student s1 = new Student("科比", 40, "名人堂", "湖人");
        Student s2 = new Student("詹姆斯", 36, "超级巨星", "骑士");
        Student s3 = new Student("欧文", 30, "巨星", "篮网");

        Map<String, Student> studentMap = new TreeMap<>();
        studentMap.put(s1.name, s1);
        studentMap.put(s2.name, s2);
        studentMap.put(s3.name, s3);

        // 当前键值对 name -> student. 给定姓名就可以查找到对应的学生信息
        String name = "科比";
        Student student = studentMap.get(name);
        System.out.println(student);

        Student s4 = new Student("莫兰特", 20, "新星", "灰熊");
        studentMap.put(s4.name, s4);

        String name1 = "莫兰特";
        Student student1 = studentMap.get(name1);
        System.out.println(student1);

        //遍历一个Map
        for (HashMap.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Iterator<Map.Entry<String, Student>> iterator = studentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
