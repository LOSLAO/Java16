

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

    //先序
    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }

    //后序
    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val + " ");
    }

    //给定一个二叉树，求二叉树中节点的个数
    public static int size(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    //求二叉树中叶子节点的个数
    /*public static int leafSize = 0;
    public static void leafSize(Node root) {
        if(root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
            return;
        }
        leafSize(root.left);
        leafSize(root.right);
    }*/

    public static int leafSize(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    //求k层节点的个数
    public static int kLevelSize(Node root, int k) {
        if(root == null || k < 1) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return kLevelSize(root.left, k - 1) + kLevelSize(root.right, k - 1);
    }

    //在一个二叉树中，查找某个值是否存在
    /*public static Node result = null;
    public static void find(Node root, char toFind) {
        if(root == null) {
            return;
        }
        if(root.val == toFind) {
            result = root;
            return;
        }
        find(root.left, toFind);
        find(root.right, toFind);
    }*/

    public static Node find(Node root, char toFind) {
        if(root ==null) {
            return null;
        }
        if(root.val == toFind) {
            return root;
        }
        Node result = find(root.left, toFind);
        if(result != null) {
            return result;
        }
        return find(root.right, toFind);
    }

    public static void main(String[] args) {
        Node root = build();
        //preOrder(root);
        //inOrder(root);
        //postOrder(root);
        //int size = size(root);
        //System.out.println(size);
        //leafSize(root);
        //System.out.println(leafSize);
        //System.out.println(leafSize(root));
        //find(root, 'H');
        //System.out.println(result);
        Node result = find(root, 'G');
        System.out.println(result);
    }
}
