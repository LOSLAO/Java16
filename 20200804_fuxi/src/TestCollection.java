import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TestCollection {
    public static void main(String[] args) {
        //1.创建collection
        Collection<String> collection = new ArrayList<>();
        //2.使用size方法
        System.out.println(collection.size());
        //3.使用isEmpty方法
        System.out.println(collection.isEmpty());
        //4.使用add方法插入元素
        collection.add("我");
        collection.add("爱");
        collection.add("你");
        //5.再次使用size和isEmpty
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        //6.可以toArray把Collection转换成数组
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        //7.可以直接使用for循环来遍历集合中的元素
        for (String s: collection) {
            System.out.println(s);
        }
        //8.使用contains方法判定元素是否存在
        System.out.println(collection.contains("我"));
        //9.使用remove来删除元素
        collection.remove("你");
        System.out.println("删除之后: ");
        for (String s: collection) {
            System.out.println(s);
        }
        //10.使用clear方法清空所有元素
        collection.clear();
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
    }
}
