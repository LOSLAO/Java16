import java.util.Scanner;

public class BuildTree {
    static class TreeNode {
        public char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            TreeNode root = buildTreeNode(line);
            inOrder(root);
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }

    private static int index = 0;
    private static TreeNode buildTreeNode(String line) {
        index = 0;
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line) {
        char ch = line.charAt(index);
        if (ch == '#') {
            return null;
        }
        TreeNode root = new TreeNode(ch);
        index++;
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;


    }


}
