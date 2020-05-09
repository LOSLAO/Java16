


public class TestInterview {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //判断一棵树是不是完全二叉树
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        findNode(root,p,q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        //采用后序遍历的形式进行查找
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid == 2) {
            lca = root;
        }
    }

    // 二叉树搜索树转换成排序双向链表
    public TreeNode Convert(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }
        // 先递归处理左子树, 这个方法一执行, 就相当于把左子树已经完整的转换成双向链表了
        // left 就是左子树链表的头结点.
        TreeNode left = Convert(root.left);
        // 处理根节点, 需要把根节点追加到左子树链表的末尾.
        // 这就相当于链表尾插, 需要先找到前面链表的最后一个节点.
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // 当上述循环结束之后, leftTail 就是 left 这个链表的最后一个节点.
        // 把当前根节点, 尾插过去
        // 当 left 为 null (没有左子树的时候), leftTail 也就是 null
        if(leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }
        // 最后递归处理右子树, right 就是右子树链表的头结点
        TreeNode right = Convert(root.right);
        if(right != null) {
            right.left = root;
            root.right = right;
        }
        return  left != null ? left : root;
    }

    //根据一棵树的前序遍历与中序遍历构造二叉树。
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        // 借助 buildTreeHelper 方法进行递归. 为了更好的描述子树, 在方法中
        // 加入一对参数表示当前子树对应的中序遍历结果的区间.
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    // [inorderLeft, inorderRight) 表示当前这个子树的中序遍历区间
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                     int inorderLeft, int inorderRight) {
        if(inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode((preorder[index]));
        int pos = find(inorder, inorderLeft, inorderRight, newNode.val);
        index++;
        newNode.left = buildTreeHelper(preorder, inorder, inorderLeft, pos);
        newNode.right = buildTreeHelper(preorder, inorder, pos + 1, inorderRight);
        return newNode;
    }

    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
