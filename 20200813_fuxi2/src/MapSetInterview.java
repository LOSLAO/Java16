import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapSetInterview {
    // 只出现一次的数字
    public int singleNumber(int[] nums) {
        //1.统计每个数字出现的次数
        //key表示具体的数字，value表示该数字在数组中出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x, 1);
            } else {
                map.put(x, count + 1);
            }
        }
        //2.循环遍历Map,找到只出现一次的数字
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        //使用按位异或的方式来解决
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        return ret;
    }

    public int[] singleNumber3(int[] nums) {
        //1.先对所有数字进行^操作
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        //2.在ret中找一个不为0的bit位
        int bit = 0;
        for (; bit < 32; bit++) {
            if ((ret & (1 << bit)) > 0) {
                break;
            }
        }
        //此时bit位对应的位就是为1
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

    //复制带随机指针的链表
    public Node copyRandomList(Node head) {
        //使用 Map 维护一个 旧节点 -> 新节点之间的映射关系.
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 下一步就可以维护 next 和 random 之间的指向了
        for (Node cur = head; cur != null; cur = cur.next) {
            // cur 是旧链表节点, newCur 是新链表的对应节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        return map.get(head);

    }

    //宝石与石头
    public int numJewelsInStones(String J, String S) {
        //J是宝石，S是石头
        //1.先把J中的字符倒腾到Set中
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        //2.再去遍历S，判定S中的字符是否在Set中存在
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }


}
