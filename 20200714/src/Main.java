


public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val =x;}
    }
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        findNode(root, a, b);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return false;
        }
        int left = findNode(root.left, a , b) ? 1 : 0;
        int right = findNode(root.right, a, b) ? 1 : 0;
        int mid = (root == a || root ==b) ? 1 : 0;
        if (left + right + mid == 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }
}
