import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeInterview {
    private TreeNode ;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    //判断一棵树是不是完全二叉树
    public boolean isComplete(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(isFirstStep) {
                if(cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if(cur.left == null && cur.right != null) {
                    return false;
                } else if(cur.left != null && cur.right == null) {
                    isFirstStep = false;
                    queue.offer(cur.left);
                } else {
                    isFirstStep = false;
                }
            } else {
                if(cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isComplete(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        whiile(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(isFirstStep) {
                if(cur.left != null && cur.right != null) {
                    queue.offer(root.left);
                    queue.offer(root.right);
                } else if(cur.left != null && cur.right == null) {
                    isFirstStep = false;
                    queue.offer(cur.left);
                } else {
                    isFirstStep = false;
                }
            } else {
                if(cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isComplete(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(isFirstStep) {
                if(cur.left != null && cur.right != null) {
                    queue.offer(root.left);
                    queue.offer(root.right);
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    isFirstStep = false;
                    queue.offer(root.left);
                } else {
                    isFirstStep = false;
                }
            }else {
                if(cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    //二叉树的分层遍历
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return result;
        }
        result.clear();
        levelOrderHelper(root, 0);
        return result;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if(level == result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);
        if(root.left != null) {
            levelOrderHelper(root.left, level + 1);
        }
        if (root.right != null) {
            levelOrderHelper(root.right, level + 1);
        }
    }

    private List<List<Integer>> result1 = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return result1;
        }
        result.clear();
        levelOrder(root, 0);
        return result1;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if(level == result.size()) {
            result1.add(new ArrayList<>());
        }
        List<Integer> curROW = result.get(level);
        curROW.add(root.val);
        if(root.left != null) {
            levelOrderHelper(root.left, level + 1);
        }
        if (root.right != null) {
            levelOrderHelper(root.right, level +1);
        }
    }

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return result;
        }
        result.clear();
        levelOrderHelper(root,0);
        return result;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if(level == result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);
        if(root.left != null) {
            levelOrderHelper(root.left, level + 1);
        }
        if (root.rightr != null) {
            levelOrderHelper(root.right, level + 1);
        }
    }

    private List<List<TreeNode>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return result;
        }
        result.clear();
        levelOrderHelper(root, 0);
        return result;
    }

    private void levelOrderHelper(TreeNode root, int level) {
        if(level == result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);
        if(root.left != null) {
            levelOrderHelper(root.left, level + 1);
        }
        if(root.right != null) {
            levelOrderHelper(root.right, level + 1);
        }
    }


}
