import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class Main {
    //数组中重复的数字
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;

    }

    //二维数组中的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    //请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字
    //符串为We%20Are%20Happy。
    public String replaceSpace(StringBuffer s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        int newLength = s.length() + 2*count;
        int newEnd = newLength - 1;
        int oldEnd = s.length() - 1;
        s.setLength(newLength);
        while (newEnd >= 0 && oldEnd >= 0) {
            if (s.charAt(oldEnd) == ' ') {
                s.setCharAt(newEnd--, '0');
                s.setCharAt(newEnd--, '2');
                s.setCharAt(newEnd--, '%');
                --oldEnd;
            } else {
                s.setCharAt(newEnd--, s.charAt(oldEnd));
                --oldEnd;
            }
        }
        return s.toString();
    }

    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] result = new int[count];
        cur = head;
        while (cur != null) {
            result[count - 1] = cur.val;
            count--;
            cur = cur.next;
        }
        return result;
    }

    //输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[index]);
        int pos = find(inorder, inorderLeft, inorderRight, newNode.val);
        index++;
        newNode.left = buildTreeHelper(preorder, inorder, inorderLeft, pos);
        newNode.right = buildTreeHelper(preorder, inorder, pos + 1, inorderRight);
        return newNode;
    }

    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft;i <= inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    //写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
    private Map<Integer, Integer> filter = new HashMap<>();
    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre = 0;
        if (filter.containsKey(n - 1)) {
            pre = filter.get(n - 1);
        } else {
            pre = fib(n - 1);
            filter.put(n - 1, pre);
        }
        int ppre = 0;
        if (filter.containsKey(n - 2)) {
            ppre = filter.get(n - 2);
        } else {
            ppre = fib(n - 2);
            filter.put(n - 2, ppre);
        }
        return ppre + pre;
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    //青蛙跳台阶
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }



}
