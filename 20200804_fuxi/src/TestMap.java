import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        //1.创建Map实例，泛型参数有两个，第一个参数是key的类型，第二个参数是value的类型
        //key value 这种结构最主要的目的就是根据key能够找到value
        Map<String, String> map = new HashMap<>();
        //2.使用size获取到元素个数（键值对个数)
        System.out.println(map.size());
        //3.使用isEmpty查看是否为空
        System.out.println(map.isEmpty());
        //4.使用put方法把一些键值对插入进去
        map.put("小飞侠", "科比");
        map.put("小皇帝", "詹姆斯");
        map.put("闪电侠", "韦德");
        map.put("甜瓜", "安东尼");
        //5.使用get方法根据key找到value
        //如果key不存在 返回null
        //gerOrDefault,如果key不存在，返回默认值
        System.out.println(map.get("小飞侠"));
        System.out.println(map.get("CP3"));
        System.out.println(map.getOrDefault("大鲨鱼", "奥尼尔"));
        //6.使用containsKey和containsValue判定某个值是否存在
        //containsKey执行效率较高，containsValue执行效率低
        System.out.println(map.containsKey("小皇帝"));
        System.out.println(map.containsValue("韦德"));
        //7.再次使用isEmpty和size
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        //8.foreach遍历map中的所有键值对
        //Entry:表示一个"条目" 也就是一个键值对
        //map.entrySet 获取到所有的键值对
        //Map中的元素顺序和插入顺序无关，取决于具体的实现方式
        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }
}
