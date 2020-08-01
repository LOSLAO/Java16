import java.util.HashMap;
import java.util.Map;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;

    }
}
public class Main {
    //大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项
    //是1）。
    //解法：剪枝
    private Map<Integer, Integer> filter = new HashMap<>();
    public int Fibonacci(int n) {
        if (n == 0 || n== 1) {
            return n;
        }
        int pre = 0;
        if (filter.containsKey(n - 1)) {
            pre = filter.get(n-1);
        } else {
            pre = Fibonacci(n-1);
            filter.put(n - 1, pre);
        }
        int ppre = 0;
        if (filter.containsKey(n-2)) {
            ppre = filter.get(n-2);
        } else {
            ppre = Fibonacci(n-2);
            filter.put(n - 2, ppre);
        }
        return ppre + pre;
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算
    //不同的结果）。
    //解法一：动态规划
    //状态定义：f(i） 跳到i台阶1的总跳发
    //状态递推公式：f(i) = f(i-1)+f(i-2)
    //状态初始值： f(0) = 1 f(1) = 1 f(2) = 2
    public int JumpFloor(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= target; i++) {
            dp[i] = dp[1] + dp[2];
        }
        return dp[target];
    }

    //我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用n个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩
    //形，总共有多少种方法？
    //解法：动态规划
    //f(n)用n个2*1的小矩形无重叠的地覆盖一个2*n的大矩形所用的总方法数
    //f(n) = f(n-1)+f(n-2)
    //f(1) = 1 f(2) = 2
    public int RectCover(int target) {
        if (target < 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n-1);
            count++;
        }
        return count;
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 0) {
            return null;
        }
        ListNode cur = head;
        ListNode prev = head;
        while (k > 0 && cur != null) {
            cur = cur.next;
            k--;
        }
        while (cur != null) {
            cur = cur.next;
            prev = prev.next;
        }
        return k > 0 ? null : prev;
    }
}
