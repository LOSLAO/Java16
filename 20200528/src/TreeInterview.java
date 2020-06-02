import java.util.LinkedList;
import java.util.Queue;

public class TreeInterview {
    static class Node {
        public char val;
        public Node left;
        public Node right;
        // 此处没有 parent. 面试中常见的二叉树都是不带 parent

        public Node(char val) {
            this.val = val;
            // 以下两个代码可以省略.
            // 引用类型的成员变量, 会被默认初始化为 null
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //1.给定一个二叉树， 求二叉树中节点的个数
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    //2.求二叉树中叶子结点的个数
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    //3.求第k层节点的个数
    public static int kLevelSize(Node root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left, k - 1) + kLevelSize(root.right, k - 1);
    }

    //4.在一个二叉树中，查找某个值是否存在
    public static Node find(Node root, char toFind) {
        if (root == null) {
            return null;
        }
        if (root.val == toFind) {
            return root;
        }
        Node result = find(root.left, toFind);
        if (result != null) {
            return result;
        }
        return find(root.right, toFind);
    }

    //5.判定两个树是否相等
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    //6.判定S中是否包含一个子树t完全相等
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) ||
                isSubtree(s.right, t);
    }

    //7.给定一个二叉树找出其最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    //8给定一个树判断它是不是高度平衡的二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth - rightDepth <= 1 && leftDepth - rightDepth >= -1)
                && isBalanced(root.left) && isBalanced(root.right);
    }

    //9.判断一个树是不是对称二叉树
    public boolean isSymmetri(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.right, t2.left)
                &&isMirror(t1.left, t2.right);
    }

    //10.层序遍历
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //11.判断一个树是不是完全二叉树
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (isFirstStep) {
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    isFirstStep = false;
                    queue.offer(cur.left);
                } else {
                    isFirstStep = false;
                }
            } else {
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }


}
