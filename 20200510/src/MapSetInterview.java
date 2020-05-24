import java.util.*;

public class MapSetInterview {
    static class Test {
        public ArrayList<Integer> data;

        public Test() {
            data = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Test{" +
                    "data=" + data +
                    '}';
        }
    }
    //1.只出现一次的数字
    //第一种方法
    public int singleNumber(int[] nums) {
        //1.统计每个数字出现的次数
        // key 表示具体的数字， value表示该数字在数组中出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int x: nums) {
            Integer count = map.get(x);
            if(count == null) {
                //x在之前没有出现过， 就把新的键值对插入到map中
                map.put(x, 1);
            } else {
                map.put(x, count + 1);
            }
        }
        //2.遍历map，找到只出现一次的数字
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //第二种方法
    public int singleNumber2(int[] nums) {
        int ret = 0;
        for (int x: nums) {
            ret ^= x;
        }
        return ret;
    }

    //找出只出现一次的那两个元素。
    public int[] singleNumber3(int[] nums) {
        //1.先针对所有的数字进行^操作
        int ret = 0;
        for (int x: nums) {
            ret ^= x;
        }
        //2.在ret中找一个不为0的bit位
        int bit = 0;
        for (; bit < 32; bit++) {
            if ((ret & (1 << bit)) > 0) {
                break;
            }
        }
        //此时bit 对应的位就是1
        //a和b是最终要找的结果
        int a = 0;
        int b = 0;
        //3.根据bit对应的位分组进行^运算
        for (int x : nums) {
            if ((x & (1 << bit)) > 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        return new int[]{a, b};
    }

    private static Test copy(Test a) {
        //浅拷贝
        Test b = new Test();
        b.data = a.data;
        return b;
    }

    private static Test deepCopy(Test a) {
        //深拷贝
        Test b = new Test();
        b.data.addAll(a.data);
        return b;
    }

    // 复制带随机指针的链表
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //1.使用Map维护一个旧节点 -》新节点之间的映射关系
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        //2.下一步就可以维护next和random之间的指向了
        for (Node cur = head; cur != null; cur = cur.next) {
            //cur是旧链表节点 newCur是新链表的对应节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        return map.get(head);
    }

    // 宝石与石头
    public int numJewelsInStones(String J, String S) {
        //第一种方法：遍历s，看s中的字符是否在j中出现,根据出现的情况来计数即可
        //这是一种简单粗暴的方法. 但是 String.contains 时间复杂度 O(N)
        //整体的复杂度就是 O(N^2)
        //S是石头, J是钻石
        /*int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (J.contains(c + "")) {
                count++;
            }
        }
        return count;*/

        // 改进思路: 不是使用 String.contains, 而是使用 Set.contains
        // 如果是 TreeSet.contains 时间复杂度 O(logN)
        // 如果是 HashSet.contains 时间复杂度 O(1)
        //1.先把J中的字符倒腾到Set中
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        //2.再去遍历S，判定S中的字符是否在Set中存在
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;

    }

    //前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        //1.统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String x: words) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        //2.把所有的map中的key倒腾到一个ArrayList中，这相当于是进行了去重
        //最终输出结果肯定不包含重复的单词的
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
        //4.根据k这个值 取出前k个元素
        return result.subList(0, k);

    }

    public static void main(String[] args) {
        Test a = new Test();
        a.data.add(1);
        a.data.add(2);
        a.data.add(3);

        Test b = deepCopy(a);
        a.data.add(4);
        System.out.println(a);
        System.out.println(b);
    }
}
