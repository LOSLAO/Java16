import java.util.ArrayList;
import java.util.List;

public class TreeInterview {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }


    //二叉树的分层遍历
    private static List<List<Integer>> result = new ArrayList<>();
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
