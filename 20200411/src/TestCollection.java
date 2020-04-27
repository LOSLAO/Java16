import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestCollection {

    public static void main(String[] args) {
        //Collection 是接口 add remove contains 这些方法都是抽象方法
        //这些方法在执行的时候，具体的行为取决于collection对应的真实对象的类型




        //1.实例化一个collection对象 Collection是一个接口 必须要new一个对应的类型作为实例才可以
        Collection<String> collection = new ArrayList<>();

        //2.使用size\isEmpty
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

        //3.用add增加元素
        collection.add("我");
        collection.add("爱");
        collection.add("你");

        //4.再次使用isEmpty \ size
        System.out.println("===============");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

        //5.toArray 把集合转换成数组
        //String 也是继承 Object  .array看似是一个Object数组其实是一个String数组
        System.out.println("================");
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(collection);

        //6.用for each 遍历collection
        System.out.println("===============");
        for (String s:collection) {
            System.out.println(s);
        }

        //7. 判定元素是否存在
        System.out.println("==================");
        boolean ret = collection.contains("我");
        System.out.println(ret);

        //使用删除方法删除指定元素
        System.out.println("====================");
        collection.remove("我");
        for (String s:collection) {
            System.out.println(s);
        }

        //9.使用clear 清空所有元素
        collection.clear();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
    }
}
