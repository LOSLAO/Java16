import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        //1.实例化一个List
        List<String> list = new ArrayList<>();
        //2.新增元素
        list.add("篮球");
        list.add("足球");
        list.add("橄榄球");
        list.add("棒球");
        list.add("冰球");
        //3.打印整个list
        System.out.println(list);
        //4.使用下标访问
        // [注意] 如果当前 List 是 ArrayList, get/set 按下标访问的方式, 是比较高效的(时间复杂度是 O(1));
        // 如果当前 List 是 LinkedList, get/set 按下标访问就比较低效. 时间复杂度是 O(N).
        System.out.println("===============");
        System.out.println(list.get(0));
        list.set(4,"网球");
        System.out.println(list.get(4));
        //6.重新构造一个list（这里的构造是浅拷贝）
        List<String> arrayList = new ArrayList<>(list);
        List<String> linkedList = new LinkedList<>(list);
        System.out.println("===================");
        System.out.println(arrayList);
        System.out.println(linkedList);
        //7.基于现有list的引用进行强制转换（向下转型）
        ArrayList<String> arrayList1 = (ArrayList<String>)list;
        LinkedList<String> linkedList1 = (LinkedList<String>)list;

    }
}
