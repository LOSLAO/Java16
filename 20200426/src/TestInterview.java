import java.util.Stack;

public class TestInterview {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

   // 根据一棵树的前序遍历与中序遍历构造二叉树
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);

    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                     int inorderLeft, int inorderRight) {
        if(inorderLeft >= inorderRight) {
            return null;
        }
        if(index >= preorder.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[index]);
        int pos = find(inorder, inorderLeft, inorderRight, newNode.val);
        newNode.left = buildTreeHelper(preorder, inorder, inorderLeft, pos);
        newNode.right = buildTreeHelper(preorder, inorder, pos + 1, inorderRight);
        return newNode;
    }

    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for(int i = inorderLeft; i < inorderRight; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    //二叉树创建字符串
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }
        helper(t);
        //删除最外侧括号
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        helper(root.left);
        if(root.left == null && root.right != null) {
            stringBuilder.append("()");
        }
        helper(root.right);
        stringBuilder.append(")");
    }

    // 二叉树的前序遍历，非递归迭代实现
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        //1.创建一个栈 初始情况下，把根节点入栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            //取栈顶元素
            TreeNode top = stack.pop();
            //访问该元素
            System.out.println(top.val + " ");
            //如果该元素的右子树不为空，就入栈
            if(top.right != null) {
                stack.push(top.right);
            }
            //如果该元素的左子树不为空也入栈，当栈为空时就遍历完成
            if(top.left != null) {
                stack.push(top.left);
            }
        }
    }

    //二叉树中序遍历 ，非递归迭代实现
    public void inOrder(TreeNode root) {
        if(root == null) {
            return ;
        }
        //设定一个栈从root出发，只要cur不为空，就把cur入栈，同时cur往左移动
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //cur为空（此时栈顶元素就是当前的最左侧元素） 出栈，并访问栈顶元素
            if(stack.empty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val + " ");
            //让cur指向刚才被访问的结点的右子树，循环执行1 2
            cur = top.right;
        }

        //二叉树的后序遍历 ，非递归迭代实现。
        public void postOrder(TreeNode root) {
            if(root == null) {
                return;
            }
            //1.创建一个cur从root出发，只要cur不为空把cur入栈，同时cur往左移动
            Stack<TreeNode> stack1 = new Stack<>();
            TreeNode cur = root;
            TreeNode prev = null;
            while(true) {
                while(cur != null) {
                    stack1.push(cur);
                    cur = cur.left;
                }
                //2.cur为空 取栈顶元素 看看能不能访问
                //满足以下两个条件 才能够访问当前栈顶元素
                //a) 栈顶元素的右子树为空
                //b) 栈顶元素的右子树已经被访问过了
                if(stack1.empty()) {
                    break;
                }
                TreeNode top = stack1.peek();
                if(top.right == null && top.right == prev) {
                    System.out.println(top.val + " ");
                    stack1.pop();
                    prev = top;
                } else {
                    //如果当前栈顶元素不满足访问的条件，让cur从栈顶元素的右子树出发，继续进行1 2
                    cur = top.right;
                }
            }
        }
    }
}
