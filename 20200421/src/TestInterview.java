import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestInterview {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    //检查两颗树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left)
                &&isSameTree(p.right, q.right);
    }

    //另一颗树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }
        return isSameTree(s,t) || isSubtree(s.left, t)
                || isSubtree(s.right, t);

    }

    //二叉树最大深度
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);

    }

    // 判断一颗二叉树是否是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return (leftDepth - rightDepth <= 1 && leftDepth - rightDepth >= -1)
                && isBalanced(root.left) && isBalanced(root.right);

    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }
        return isMirror(root.left, root.right);

    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    //二叉树的分层遍历
    public void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        //1.创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            //取出队首元素
            TreeNode cur = queue.poll();
            //访问当前元素
            System.out.println(cur.val + " ");
            //那当前节点的左右子树分别加入队列
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }

    }

    public static TreeNode build2() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }


    public static void main(String[] args) {
        TreeNode root = build2();
        TestInterview interview = new TestInterview();
        interview.levelOrder(root);
    }


}
