import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class TestDemo {
    //输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出
    //来的所有字符串 abc,acb,bac,bca,cab 和 cba 。
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str != null && str.length() != 0) {
            PermutationHelper(str.toCharArray(), 0, result);
            Collections.sort(result);
        }
        return result;
    }

    private void PermutationHelper(char[] str, int start, ArrayList<String> result) {
        if (start == str.length - 1) {
            if (!IsExist(result, str)) {
                result.add(new String(str));
            }
            return;
        }
        for (int i = start; i < str.length; i++) {
            swap(str, start, i);
            PermutationHelper(str, start + 1, result);
            swap(str, start, i);
        }
    }

    private boolean IsExist(ArrayList<String> result, char[] str) {
        return result.contains(String.valueOf(str));
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    //输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                queue.offer(input[i]);
            } else {
                if (input[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }
}
