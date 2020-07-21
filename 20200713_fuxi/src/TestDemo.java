

class Person {
    //name age都是成员变量
    //成员变量就是定义在方法外但在类里面的变量
    //实例成员变量:对象里面
    //实例成员没有初始化，默认值为对应的0值，引用类型为null,简单类型默认为0
    public String name = "LA";
    public int age = 20;
    //此处的size就是静态成员变量 它不属于对象，属于类
    public static int size = 10;
    public void eat() {
        System.out.println("吃饭！");
    }
    public void sleep() {
        System.out.println("睡觉！");
    }
    public static void func1() {

        System.out.println("static::func1");
    }
    public void show() {
        System.out.println("我叫" + name + ", 今年" + age + "岁");
    }
}
class Test {
    public int a;
    public static int count;
}

public class TestDemo {

    public static void main6(String[] args) {
        Test test = new Test();
        test.a++;
        Test.count++;
        System.out.println(test.a);//1
        System.out.println(Test.count);//1
        System.out.println("=================");
        Test test1 = new Test();
        test1.a++;
        Test.count++;
        System.out.println(test1.a);//1
        System.out.println(Test.count);//2
    }
    public static void main5(String[] args) {
        Person person = new Person();
        person.show();
        person.name = "KOBE";
        person.age = 40;
        person.show();
    }
    public static void main4(String[] args) {
        Person.func1();
    }
    public static void main3(String[] args) {
        //如何访问静态成员变量
        System.out.println(Person.size);//10
    }
    public static void main2(String[] args) {
        Person person = new Person();
        System.out.println(person.name);//LA
        System.out.println(person.age);//20
    }
    public static void main1(String[] args) {
        Person person = new Person();
        System.out.println(person.name);//null
        System.out.println(person.age);//0
    }


}
