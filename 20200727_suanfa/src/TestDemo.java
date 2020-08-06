import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo {


    //HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
    //常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某
    //个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为
    //止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1）
    //解法一：动态规划
    //定义状态：f(i): 以i下标结尾的最大连续子序列的和
    //状态地推： f(i) = max(f(i-1) + array(i), array[i])
    //状态初始化：f(0) = array(0),
    public int FindGreatestSumOfSubArray1(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max_value = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            if (max_value < dp[i]) {
                max_value = dp[i];
            }
        }
        return max_value;
    }

    //解法二：优化 如果对于累计和有利于增大的 存下来 不利于增大的丢弃
    public int FindGreatestSumOfSubArray(int[] array) {
        int total = array[0];
        int max_value = array[0];
        for (int i = 1; i < array.length; i++) {
            if (total >= 0) {
                //如果之前total累计的和>=0,说明当前数据+total，有利于整体增大
                total += array[i];
            } else {
                //如果之前累计的和<0,说明当前数据+total，不利于整体增大,丢弃之前的所有值
//这里有一个基本事实，就是之前的连续数据和是确定的。
//连续，是可以从以前到现在，也可以是从现在到以后。至于要不要加以前，就看以前对整体增大又没有
                total = array[i];
            }
            if (max_value < total) {
                max_value = total;
            }
        }
        return max_value;
    }


    //给定一个仅由小写字母组成的字符串。现在请找出一个位置，删掉那个字母之后，字符串变成回文。请放心总会有一
    //个合法的解。如果给定的字符串已经是一个回文串，那么输出-1。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num > 0) {
            StringBuffer sb = new StringBuffer(scanner.next());
            int[] start = new int[1];
            int[] end = new int[1];
            if (IsPalindrome(sb, start, end)) {
                System.out.println(-1);
            } else {
                sb.deleteCharAt(end[0]);
                if (IsPalindrome(sb, null, null)) {
                    System.out.println(end[0]);
                } else {
                    System.out.println(start[0]);
                }
            }
            num--;
        }
    }

    private static boolean IsPalindrome(StringBuffer sb, int[] start, int[] end) {
        int i = 0;
        int j = sb.length() - 1;
        boolean result = true;
        while (i <= j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                result = false;
                break;
            }
            i++;
            j--;
        }
        if (start != null) {
            start[0] = i;
        }
        if (end != null) {
            end[0] = j;
        }
        return result;
    }

    //输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数
    //组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null) {
            return new String();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int e : numbers) {
            list.add(e);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                String xs = x + "" + y;
                String ys = y + "" + x;
                return xs.compareTo(ys);
            }
        });
        String result = new String();
        for (Integer e : list) {
            result += e;
        }
        return result;
    }


    //输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显
    //示的，保证传入数据是正确的）
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode PL = pHead1;
        ListNode PS = pHead2;
        while (PL != null) {
            lenA++;
            PL = PL.next;
        }
        while (PS != null) {
            lenB++;
            PS = PS.next;
        }
        PL = pHead1;
        PS = pHead2;
        int len = lenA - lenB;
        while (len > 0) {
            PL = PL.next;
            len--;
        }
        while (PL != PS) {
            PS = PS.next;
            PL = PL.next;
        }
        if (PL == PS && PL != null && PS != null) {
            return PL;
        }
        return null;
    }


    //输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径
    //的长度为树的深度。
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }


}
