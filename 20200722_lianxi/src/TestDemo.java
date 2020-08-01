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

public class TestDemo {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        return reConstructBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
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


    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newLength = str.length() + 2 * count;
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
            } else if (target == array[i]) {
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
        return times > array.length/2 ? target : 0;
    }

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
            if (map.get(array[i]) > array.length/2) {
                return array[i];
            }
        }
        return 0;
    }


}
