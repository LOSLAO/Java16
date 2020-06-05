import java.util.Scanner;
import java.util.Set;

public class BuildTree {
    static class  TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            index = 0;
            TreeNode root = createTreePreOrder(line);
            inOrder(root);
            System.out.println();
        }
    }

    private static int index = 0;
    private static TreeNode createTreePreOrder(String line) {
        char ch = line.charAt(index);
        if (ch == '#') {
            return null;
        }
        TreeNode node = new TreeNode(ch);
        index++;
        node.left = createTreePreOrder(line);
        index++;
        node.right = createTreePreOrder(line);
        return node;
    }
}
