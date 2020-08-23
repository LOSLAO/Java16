import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Cat {
    private String name = "汤姆";

    public Cat() {

    }

    public void eat(String food) {
        System.out.println(name + " 正在吃 " + food);
    }

    public Cat(String name) {
        this.name = name;
    }
}
public class TestReflect {
    // 通过反射来实例化对象
    public static void testInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class catClass = Class.forName("Cat");
        Cat cat = (Cat) catClass.newInstance();
    }

    //通过反射来获取到对象的属性
    public static void testField() throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        //1.先获取到类对象
        Class catClass = Class.forName("Cat");
        //2.借助类对象，获取到指定的Field对象
        //    现在这一步获取到的 field 对象相当于从一个大图纸中获取了一个局部的图纸.
        Field field = catClass.getDeclaredField("name");
        field.setAccessible(true);// 专门处理 private 成员的方式. 破门而入.
        //3.根据图纸来修改/获取到对象的相关字段
        Cat cat = new Cat();
        // 可以通过 get 方法获取对应属性
        // 也可以通过 set 方法来修改属性
        field.set(cat, "咪咪");
        String name = (String) field.get(cat);
        System.out.println(name);
    }

    //获取类当中的方法
    public static void testMethod() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        //1.先获取到类对象
        Class catClass = Class.forName("Cat");
        // 2. 根据类对象, 根据名字获取到指定的 Method 对象
        //    getMethod 从第二个参数开始, 其实是用来描述当前 eat 对应的方法应该是哪个版本(当出现 eat 被重载的时候, 能够借助参数列表的类型区分出来).
        //    上面的代码是获取到一个参数的版本的 eat
        Method method = catClass.getMethod("eat", String.class);
        method.setAccessible(true);
        // 3. 借助 Method 对象来调用指定的方法(对于非静态方法, 需要指定实例来调用).
        Cat cat = new Cat();
        method.invoke(cat, "鱼");
    }

    //获取构造方法
    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.获取到类对象
        Class catClass = Class.forName("Cat");
        // 2. 借助类对象获取 Constructor 对象
        //    下面的操作意思是获取到参数为一个 String 的构造方法.
        Constructor constructor = catClass.getConstructor(String.class);
        constructor.setAccessible(true);
        // 3. 根据 Constructor 实例化对象
        Cat cat = (Cat) constructor.newInstance("小猫");
        cat.eat("猫粮");
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //testField();
        //testMethod();
        testConstructor();
    }
    public static void main1(String[] args) throws ClassNotFoundException {
        // 获取类对象, 获取到 Cat 类的说明书.
        // 第一种获取方式是最灵活的. 写代码的时候根本就不需要知道类名. 在实际运行时再获取类名.
        // 第二种和第三种方式都是需要在写代码的时候就要知道类名.
        // 1. 直接通过全限定类名类获取.
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        Class catClass = Class.forName(name);
        //2.通过类的实例来获取
        Cat cat = new Cat("咪咪");
        Class catClass2 = cat.getClass();
        //3.通过类来直接获取
        Class catClass3 = Cat.class;

        System.out.println(catClass == catClass2);
        System.out.println(catClass == catClass3);
    }

}
