import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreeInterView {
    //判断一棵树是不是完全二叉树
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
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    isFirstStep = false;
                    queue.offer(cur.left);
                } else {
                    isFirstStep = false;
                }
            } else {
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (isFirstStep) {
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    isFirstStep = false;
                    queue.offer(cur.left);
                } else {
                    isFirstStep = false;
                }
            } else {
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    //分层遍历
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
            result.add(new ArrayList<>());
        }
        List<Integer> curRow = result.get(level);
        curRow.add(root.val);
        if (root.left != null) {
            levelOrderHelper(root.left, level+1);
        }
        if (root.right != null) {
            levelOrderHelper(root.right, level+1);
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
            levelOrderHelper1(root.left, level+1);
        }
        if (root.right != null) {
            levelOrderHelper1(root.right, level+1);
        }
    }

    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
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
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid > 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode1(root, p, q);
        return lca;

    }

    private boolean findNode1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = findNode1(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid == 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }

    //二叉树搜索树转换成排序双向链表
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        //先递归处理左子树, 这个方法一执行, 就相当于把左子树已经完整的转换成双向链表了
        // left 就是左子树链表的头结点.
        TreeNode left = Convert(root.left);
        // 处理根节点, 需要把根节点追加到左子树链表的末尾.
        // 这就相当于链表尾插, 需要先找到前面链表的最后一个节点.
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // 当上述循环结束之后, leftTail 就是 left 这个链表的最后一个节点.
        // 把当前根节点, 尾插过去
        // 当 left 为 null (没有左子树的时候), leftTail 也就是 null
        if (leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }
        // 最后递归处理右子树, right 就是右子树链表的头结点
        TreeNode right = Convert(root.right);
        if (right != null) {
            right.left = root;
            root.right = right;
        }
        //// 返回整个链表的头结点
        return left != null ? left : root;

    }

    public TreeNode Convert1(TreeNode root) {
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
            leftTail.left = root;
        }
        TreeNode right = Convert(root.right);
        if (right != null) {
            right.left = root;
            root.right = right;
        }
        return left != null ? left : root;
    }

    public TreeNode Convert2(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = Convert2(root.left);
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
            right.left = root;
            root.right = left;
        }
        return left != null ? left : root;


    }

    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        // 借助 buildTreeHelper 方法进行递归. 为了更好的描述子树, 在方法中
        // 加入一对参数表示当前子树对应的中序遍历结果的区间.
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[index]);
        int pos = find(inorder, inorderLeft, inorderRight, newNode.val);
        index++;
        newNode.left = buildTreeHelper(preorder, inorder, inorderLeft, pos);
        newNode.right = buildTreeHelper(preorder, inorder, pos+1, inorderRight);
        return newNode;
    }

    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper1(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper1(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[index]);
        int pos = find1(inorder, inorderLeft, inorderRight, newNode.val);
        newNode.left = buildTreeHelper1(preorder, inorder, inorderLeft, pos);
        newNode.right = buildTreeHelper1(preorder, inorder, pos+1, inorderRight);
        return newNode;
    }

    private int find1(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        index = 0;
        buildTreeHelper2(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper2(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[index]);
        int pos = find2(inorder, inorderLeft, inorderRight, newNode.val);
        newNode.left = buildTreeHelper2(preorder, inorder, inorderLeft, pos);
        newNode.right = buildTreeHelper2(preorder, inorder, pos+1, inorderRight);
        return newNode;
    }

    private int find2(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    //二叉树创建字符串
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        helper(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();

    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        //采用前序遍历
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        helper(root.left);
        if (root.left == null && root.right != null) {
            stringBuilder.append("()");
        }
        helper(root.right);
        stringBuilder.append(")");
    }

    public String tree2str1(TreeNode t) {
        if (t == null) {
            return null;
        }
        helper1(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private void helper1(TreeNode root) {
        if (root == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        helper1(root.left);
        if (root.left == null && root.right != null) {
            stringBuilder.append("()");
        }
        helper1(root.right);
        stringBuilder.append(")");
    }

    public String tree2str2(TreeNode t) {
        if (t == null) {
            return null;
        }
        helper2(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private void helper2(TreeNode root) {
        if (root == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        helper2(root.left);
        if (root.left == null && root.right != null) {
            stringBuilder.append("()");
        }
        helper2(root.right);
        stringBuilder.append(")");
    }

    private static TreeNode build() {
        // 通过 build 方法构建一棵树, 返回树的根节点.
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
            System.out.println(top.val);
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
            //1.让cur一直往左找，循环入栈，直到cur为空
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //2.取栈顶元素元素并访问，如果遇到空栈，说明访问完毕
            if (stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val + " ");
            //3.cur从top的右子树出发，重复1，2
            cur = top.right;
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // prev 用来记录上一个被访问过的节点. 初始情况下没有任何节点被访问过.
        TreeNode prev = null;
        while (true) {
            //1.// 1. cur 循环往左找, 遇到的非空节点都入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 2. 取栈顶元素, 看看能不能访问这个元素
            //    满足以下两个条件, 才能够访问当前栈顶元素
            //   a) 右子树为空
            //   b) 右子树被访问过
            if (stack.empty()) {
                break;
            }
            TreeNode top = stack.peek();// // 只是取元素判断一下, 并没有真的出栈. 只有这个节点被访问过了, 才能出栈.
            if (top.right == null || top.right == prev) {
                System.out.println(top.val + " ");
                stack.pop();
                prev = top;
            } else {
                //. 让 cur 从 top.right 出发, 继续循环 1 和 2
                cur = top.right;
            }
        }
    }


}
