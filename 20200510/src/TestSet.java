import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //1.add插入元素，add多个相同元素，最终在Set中只有一份（去重）
        set.add("篮球");
        set.add("篮球");
        set.add("篮球");
        set.add("足球");
        set.add("羽毛球");
        set.add("橄榄球");
        set.add("棒球");
        //2.Set典型应用，判定某个元素是否在set中存在
        System.out.println(set.contains("橄榄球"));
        //3.删除元素
        set.remove("足球");
        System.out.println(set.contains("足球"));
        //4.打印所有元素
        System.out.println(set);
        //5.使用for each遍历
        for (String s: set) {
            System.out.println(s);
        }
        //6.使用迭代器来遍历集合类
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
