import java.util.*;

public class BrokenKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //1.处理输入，读取输入字符串
            String expected = scanner.next();
            String actual = scanner.next();
            //2.把两个字符串都转成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            //3.把actual中的字符放到一个set当中
            Set<Character> setActual = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                setActual.add(actual.charAt(i));
            }
            //4.遍历预期输出的字符串，看这里的字符那些没有在setActual中出现，没出现的字符就是坏键
            Set<Character> brokenKey = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (setActual.contains(c)) {
                    //存在就是坏键
                    continue;
                }
                // 这是一个坏键, 输出之. 但是别忘了, 坏键不需要重复输出
                if (brokenKey.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKey.add(c);
            }
            System.out.println();
        }
    }

    // 前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        //1.统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        //2.把所有的 map 中的 key 倒腾到一个 ArrayList 中, 这相当于是进行了去重
        //最终输出结果肯定不包含重复的单词的.
        List<String> result = new ArrayList<>(map.keySet());
        //3.根据单词出现的次数针对 result 进行排序了
        //按照出现次数降序排序. 如果两个单词出现次数一样, 再按字典序排序
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 在这个匿名内部类里, 可以访问到上面的 map 变量.
                // 变量捕获
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2) {
                    return o1.compareTo(o2);
                }
                return count2 - count1;
            }
        });
        //4.根据k这个值，取出前k个元素
        return result.subList(0, k);
    }
}
