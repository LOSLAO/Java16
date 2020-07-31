import javax.swing.plaf.nimbus.State;
import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
    this.val = val;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Main {
    //数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组
    //{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则
    //输出0。
    //解法一：定义map，使用<数字，次数>的映射关系，最后统计每个字符出现的次数
    public int MoreThanHalfNum_Solution1(int [] array){
       if (array == null) {
           return 0;
       }
       Map<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < array.length; i++) {
           if (map.containsKey(array[i])) {
               int count = map.get(array[i]);
               count++;
               map.put(array[i], count);
           } else {
               map.put(array[i], 1);
           }
           if (map.get(array[i]) > array.length / 2) {
               return array[i];
           }
       }
       return 0;
    }
    //解法二：排序，出现次数最多的数字，一定在中间位置。然后检测中间出现的数字出现的次数是否符合要求
    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array == null) {
            return 0;
        }
        Arrays.sort(array);
        int target = array[array.length/2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                count++;
            }
        }
        if (count > array.length/2) {
            return target;
        }
        return 0;
    }

    //解法三：
    //目标数据超过数组长度的一半，那么对数组，我们同时去掉两个不同的数字，到最后剩
    //下的一个数就是该数字。如果剩下两个，那么这两个也是一样的，就是结果），在其基础上把最后剩下的一个
    //数字或者两个回到原来数组中，将数组遍历一遍统计一下数字出现次数进行最终判断。
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null) {
            return 0;
        }
        int target = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                target = array[i];
                times = 1;
            }else if (array[i] == target) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                times++;
            }
        }
        return times > array.length / 2 ? target : 0;
    }

    //请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过
    //替换之后的字符串为We%20Are%20Happy。
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newLength = str.length() + 2*count;
        int oldEnd = str.length() - 1;
        int newEnd = newLength - 1;
        str.setLength(newLength);
        while (oldEnd >= 0 && newEnd >= 0) {
            if (str.charAt(oldEnd) == ' ') {
                str.setCharAt(newEnd--, '0');
                str.setCharAt(newEnd--, '2');
                str.setCharAt(newEnd--, '%');
                oldEnd--;
            } else {
                str.setCharAt(newEnd, str.charAt(oldEnd));
                newEnd--;
                oldEnd--;
            }
        }
        return str.toString();
    }

    //输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    //解法一：
    //stack方式
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    //解法二：
    //逆置数组
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
        return list;
    }

    //解法3
    //递归方式
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        printListFromTailToHeadCore(list, listNode);
        return list;
    }

    private void printListFromTailToHeadCore(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null) {
            return;
        }
        printListFromTailToHeadCore(list, listNode.next);
        list.add(listNode.val);
    }

    //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重
    //复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        return reConstructBinaryTreeCore(pre, 0, pre.length-1, in, 0, in.length - 1);

    }

    private TreeNode reConstructBinaryTreeCore(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = reConstructBinaryTreeCore(pre, preStart + 1, i - inStart + preStart, in, inStart, i - 1);
                root.right = reConstructBinaryTreeCore(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }


}
