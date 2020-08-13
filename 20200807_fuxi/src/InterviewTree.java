import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int val) {
          this.val = val;
      }
  }


public class InterviewTree {

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    //检查两颗树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            //如果是空树认为相等
            return true;
        }
        if (p == null || q == null) {
            // 如果两个树一个为空一个非空, 那么最终结果肯定不相等.
            // 由于前面还有一个 p q 均为空的条件限制, 此处 这个条件的 含义是, p 和 q 一个为空一个非空
            return false;
        }
        // 还是按照递归的方式把问题拆分:
        // 判定 p 和 q 是否相等 => p.val == q.val && p.left 和 q.left 相等, && p.right 和 q.right 相等
        return p.val == q.val && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    //另一颗树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //先遍历s这个树，访问到某个结点时，“访问”操作就是isSameTree的判定
        if (s == null) {
            return false;
        }
        //判断s中是否包含t=》先看s和t是否相同 || s.left包含t||s.right包含t
        return isSameTree(s, t) || isSubtree(s.left, t) ||
                isSubtree(s.right, t);
    }

    // 二叉树最大深度
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

    //. 判断一颗二叉树是否是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        //求当前节点左右子树的高度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        //当前这个树平衡 =》当前节点左右子树高度差《= 1 && 左子树是平衡的 && 右子树是平衡的
        return (leftDepth - rightDepth <= 1 && leftDepth - rightDepth >= -1)
                && isBalanced(root.left) && isBalanced(root.right);
    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
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
        return (t1.val == t2.val) && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    //二叉树的分层遍历
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //取出队首元素
            TreeNode cur = queue.poll();
            //访问当前元素
            System.out.println(cur.val + " ");
            //把当前节点的左右子树分别入队列
            if (cur.left != null) {
                queue.offer(root.left);
            }
            if (cur.right != null) {
                queue.offer(root.right);
            }

        }
    }

    //判断一棵树是不是完全二叉树
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isFirstStep = true;
        //这个变量为true表示当前在第一阶段，为false表示当前在第二阶段
        //针对这个树进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (isFirstStep) {
                //第一阶段，要求任意节点必须具备两个子树
                if (cur.left != null && cur.right != null) {
                    //当前节点有两个子树，直接把子树入队列，继续往后遍历
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    return false;
                    //当前节点右子树非空，左子树为空，这时候就一定不是完全二叉树
                } else if (cur.left != null && cur.right == null){
                    //当前节点左子树非空，右子树为空，此时进入第二阶段
                    isFirstStep = false;
                    queue.offer(cur.left);
                } else {
                    //当前节点左右子树都为空，进入第二阶段
                    isFirstStep = false;
                }
            } else {
                //第二阶段，要求任意节点必须没有子树
                if (cur.left != null || cur.right != null) {
                    //对反例进行判定 不是完全二叉树就false
                    return false;
                }
            }
        }
        //树遍历完，也就没有找到反例，最终就认为是完全二叉树
        return true;
    }

    public boolean isComplete1(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (isFirstStep) {
                if (root.left != null && root.right != null) {
                    queue.offer(root.left);
                    queue.offer(root.right);
                } else if (root.left == null && root.right != null) {
                    return false;
                } else if (root.left != null && root.right == null) {
                    isFirstStep = false;
                    queue.offer(root.left);
                } else {
                    isFirstStep = false;
                }
            } else {
                if (cur.left != null || root.right != null) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isComplete2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (isFirstStep) {
                if (root.left != null && root.right != null) {
                    queue.offer(root.left);
                    queue.offer(root.right);
                } else if (root.left == null && root.right != null) {
                    return false;
                } else if (root.left != null && root.right == null) {
                    isFirstStep = false;
                    queue.offer(root.left);
                } else {
                    isFirstStep = false;
                }
            } else {
                if (root.left != null || root.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    //二叉树的分层遍历
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.clear();
        levelOrderHelper(root, 0);
        return result;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if (level == result.size()) {
            //当前level在result中没有对应的行,加入一行
            result.add(new ArrayList<>());
        }
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);//先序遍历的访问操作
        if (root.left != null) {
            levelOrderHelper(root.left, level + 1);
        }
        if (root.right != null) {
            levelOrderHelper(root.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.clear();
        levelOrderHelper1(root, 0);
        return result;
    }

    private void levelOrderHelper1(TreeNode root, int level) {
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);
        if (root.left != null) {
            levelOrderHelper(root.left, level + 1);
        }
        if (root.right != null) {
            levelOrderHelper(root.right, level + 1);
        }
    }


}
