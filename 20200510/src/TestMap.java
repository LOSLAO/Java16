import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Student {
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
        Student s1 = new Student("科比", 40, "大四", "湖人大学");
        Student s2 = new Student("詹姆斯", 35, "大三", "骑士大学");
        Student s3 = new Student("库里", 30, "大二", "勇士大学");

        Map<String, Student> studentMap = new TreeMap<>();
        studentMap.put(s1.name, s1);
        studentMap.put(s2.name, s2);
        studentMap.put(s3.name, s3);

        // 当前键值对 name -> student. 给定姓名就可以查找到对应的学生信息
        String name = "科比";
        Student student = studentMap.get(name);
        System.out.println(student);

        Student s4 = new Student("科比", 18, "大一", "黄蜂大学");
        studentMap.put(s4.name, s4);
        Student student1 = studentMap.get(name);
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

        // 如果想按照其他映射来查找, 例如按年龄, 就需要其他的 Map
        //Map<Integer, Student> studentMap1 = new HashMap<>();
        //studentMap1.put(s1.age, s1);
        //studentMap1.put(s2.age, s2);
        //studentMap1.put(s3.age, s3);

        //Student student2 = studentMap1.get(35);
        //System.out.println(student2);
    }
}
