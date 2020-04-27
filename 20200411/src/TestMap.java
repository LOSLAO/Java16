import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        //1.实例化一个Map
        Map<String, String> map = new HashMap<>();

        //2. isEmpty \ size
        System.out.println(map.isEmpty());
        System.out.println(map.size());

        //3.put插入若干个键值对 key => value 反向不行
        map.put("黑曼巴", "科比");
        map.put("小皇帝", "詹姆斯");
        map.put("闪电侠", "韦德");
        map.put("狼王", "加内特");

        //4.使用get 根据key 找一下 value
        System.out.println(map.get("黑曼巴"));
        System.out.println(map.get("甜瓜"));
        //找到key 返回对应的value 如果没找到key 返回默认值
        System.out.println(map.getOrDefault("甜瓜", "安东尼"));

        //5.使用contains 判定元素是否存在
        System.out.println("================");
        // containsKey 比较高效  containsValue 比较低效
        System.out.println(map.containsKey("小皇帝"));
        System.out.println(map.containsValue("詹姆斯"));//不推荐使用

        //6.循环遍历Map 此处的Entry 表示 "条目" 一个一个的键值对
        // 对于Map 来说 保存的元素顺序和插入顺序无关
        //Map 内部对于元素顺序有自己的规则
        for (Map.Entry<String, String>entry: map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue() );
        }

        //7. clear 清空所有元素
        map.clear();
        System.out.println(map.isEmpty());
        System.out.println(map.size());
    }


}
