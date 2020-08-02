import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    //定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
    //注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
    private Stack<Integer> data_stack = new Stack<>();
    private Stack<Integer> min_stack = new Stack<>();
    public void push(int node) {
        data_stack.push(node);
        if (min_stack.empty() || node < min_stack.peek()) {
            min_stack.push(node);
        } else {
            min_stack.push(min_stack.peek());
        }
    }
    public void pop() {
        data_stack.pop();
        min_stack.pop();
    }
    public int top() {
        return data_stack.peek();
    }
    public int min() {
        return min_stack.peek();
    }

    //输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所
    //有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但
    //4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    public boolean IsPopOrder(int [] pushA,int [] popA) {
       if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0
           || pushA.length != popA.length) {
           return false;
       }
       Stack<Integer> stack = new Stack<>();
       int i = 0;
       int j = 0;
       for (; i < pushA.length; i++) {
           stack.push(pushA[i]);
           while (!stack.empty() && stack.peek() == popA[j]) {
               stack.pop();
               j++;
           }
       }
       return stack.empty();
    }

    //二叉树层序遍历
    //从上往下打印出二叉树的每个节点，同层节点从左至右打印
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode father = queue.poll();
            list.add(father.val);
            if (father.left != null) {
                queue.offer(father.left);
            }
            if (father.right != null) {
                queue.offer(father.right);
            }
        }
        return list;

    }


}
