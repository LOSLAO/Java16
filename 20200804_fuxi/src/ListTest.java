import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        //1.创建list对象
        List<String> list = new ArrayList<>();
        //2.新增元素
        list.add("科比");
        list.add("詹姆斯");
        list.add("韦德");
        list.add("安东尼");
        //3.打印整个list
        System.out.println(list);
        //4.按照下标来访问元素
        System.out.println(list.get(0));
        //5.根据下表来修改元素
        list.set(3, "库里");
        System.out.println(list);
        //6.使用for循环来仿问每个元素
//        for (String s: list) {
//            System.out.println(s);
//        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //7.使用sublist获取子序列
        System.out.println(list.subList(0,2));
        //可以使用构造方法构造出新的List对象
        List<String> list1 = new ArrayList<>(list);
        System.out.println(list1);

    }
}
