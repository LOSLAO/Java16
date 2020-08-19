import java.util.*;

public class MapSetInterview {
    //只出现一次的数字
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
                return entry.getValue();
            }
        }
        return 0;
    }

    public int singleNumber1(int[] nums) {
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

    public int singleNumber3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer count = map.get(x);
            if (count == null) {
                map.put(x, 1);
            } else {
                map.put(x, count + 1);
            }

        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumber4(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        return ret;
    }

    //两个只出现一次的数字
    public int[] singleNumber5(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        int bit = 0;
        for (; bit < 32; bit++) {
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

    public int[] singleNumber6(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        int bit = 0;
        for (; bit < 32; bit++) {
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
        Map<Node, Node> map = new HashMap<>();
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

    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
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
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
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

    public int numJewelsInStones1(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
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

    //前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                return count2 - count1;
            }
        });
        return result.subList(0, k);
    }


    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            map.put(x, map.getOrDefault(x, 0) + 1);

        }
        List<String> result = new ArrayList<>();
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                return count2 - count1;
            }
        });
        return result.subList(0, k);
    }

}
