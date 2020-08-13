public class TestTree {
    static class Node {
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    //先序遍历
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }
    //后序遍历
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val + " ");
    }

    //写一个方法，求二叉树中节点的个数
    //利用递归
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
    //不用递归
    public static int treeSize = 0;
    public static void size1(Node root) {
        if (root == null) {
            return;
        }
        treeSize++;
        size(root.left);
        size(root.right);
    }

    //求二叉树叶子结点的个数
    //利用递归
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    //不用递归
    public static int leafSize = 0;
    public static void leafSize1(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
            return;
        }
        leafSize1(root.left);
        leafSize1(root.right);
    }

    //求二叉树第k层节点的个数
    public static int kLevelSize(Node root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left,k-1) + kLevelSize(root.right, k-1);
    }

    //在二叉树中查找指定元素
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


}
