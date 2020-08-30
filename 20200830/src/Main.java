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
    //给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三
    //小结点的值为4。
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        do {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                k--;
                if (k == 0) {
                    return node;
                }
                node = node.right;
            }
        } while (node != null || !stack.empty()) {
            return null;
        }
    }

    TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        do {
            while (node != null) {
                stack.push(node);
                node = node.left;

            }
            if (!stack.empty()) {
                node = stack.pop();
                k--;
                if (k == 0) {
                    return node;
                }
                node = node.right;
            }
        } while (node != null || !stack.empty());
        return null;
    }

    //请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三
    //行按照从左到右的顺序打印，其他行以此类推
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(pRoot);
        int count = 1;//代表left->right式入栈. 2: 代表right->left式入栈
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                TreeNode first = (count == 1) ? cur.left : cur.right;
                TreeNode second = (count == 1) ? cur.right : cur.left;
                if (first != null) {
                    queue.offer(first);
                }
                if (second != null) {
                    queue.offer(second);
                }
            }
            result.add(new ArrayList(list));
            list.clear();
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
            count = (count == 1) ? 2 : 1;
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(pRoot);
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                TreeNode first = (count == 1) ? cur.left : cur.right;
                TreeNode second = (count == 1) ? cur.right : cur.left;
                if (first != null) {
                    queue.offer(first);
                }
                if (second != null) {
                    queue.offer(second);
                }
            }
            result.add(new ArrayList<>());
            list.clear();
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
            count = (count == 1) ? 2 : 1;
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> Print3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(pRoot);
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                TreeNode first = (count == 1) ? cur.left : cur.right;
                TreeNode second = (count == 1) ? cur.right : cur.left;
                if (first != null) {
                    queue.offer(first);
                }
                if (second != null) {
                    queue.offer(second);
                }
            }
            result.add(new ArrayList(list));
            list.clear();
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
            count = (count == 1) ? 2 : 1;
        }
        return result;
    }

}
