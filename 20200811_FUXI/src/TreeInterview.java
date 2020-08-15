import java.util.Stack;

public class TreeInterview {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    //最近公共祖先
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root, p, q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == q || root == p) ? 1 : 0;
        if (left + right + mid == 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }

    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = Convert(root.left);
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }
        TreeNode right = Convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left != null ? left : root;
    }


    private int index = 0;
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        index = 0;
        return buildTreeHelper(preOrder, inOrder, 0, inOrder.length);
    }

    private TreeNode buildTreeHelper(int[] preOrder, int[] inOrder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= preOrder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preOrder[index]);
        int pos = find(inOrder, inorderLeft, inorderRight, newNode.val);
        index++;
        newNode.left = buildTreeHelper(preOrder, inOrder, inorderLeft, pos);
        newNode.right = buildTreeHelper(preOrder, inOrder, pos+1, inorderRight);
        return newNode;
    }

    private int find(int[] inOrder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (inOrder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        helper(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        helper(root.left);
        if (root.left == null && root.right != null) {
            stringBuilder.append("()");
        }
        helper(root.right);
        stringBuilder.append(")");
    }

    public static TreeNode build() {
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

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            System.out.println(top.val + " ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val + " ");
            cur = top.right;
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.empty()) {
                break;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                System.out.println(top.val + " ");
                stack.pop();
                prev = top;
            } else {
                cur = top.right;
            }
        }
    }
}
