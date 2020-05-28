import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

import java.util.*;

public class MapSetInterview {

    //1.找到只出现一次的次数
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x, 1);
            } else {
                map.put(x, count + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        return ret;
    }

    //2.找两个只出现一次的数字
    public int[] singleNumber3(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        int bit = 0;
        for (; bit < 32; bit ++) {
            if ((ret & (1 << bit)) > 0) {
                break;
            }
        }
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if ((x & (1 << bit)) > 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        return new int[]{a, b};
    }

    //3.复制带随机指针的链表
    static class Node{
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
        Map<Node,Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        return map.get(head);
    }

    //宝石与石头
    public int numJewelIsInStones(String J, String S) {
        //J是宝石， S是石头
        /*int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (J.contains(c + " ")) {
                count++;
            }
        }*/

        int count = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    //5.前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
       Map<String, Integer> map = new HashMap<>();
       for (String x : words) {
           map.put(x, map.getOrDefault(x , 0) + 1);
       }
       List<String> result = new ArrayList<>(map.keySet());
       Collections.sort(result, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               int count1 = map.get(o1);
               int count2 = map.get(o2);
               if (count1 == count2) {
                   return o1.compareTo(o2);
               }
               return count2 - count1;
           }
       });
       return result.subList(0, k);
    }
}
