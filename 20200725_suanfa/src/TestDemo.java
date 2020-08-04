import java.util.ArrayList;
import java.util.Collections;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class TestDemo {



    //输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输
    //入的数组的任意两个数字都互不相同。
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBSTCore(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int i = 0;
        while (i < end && sequence[i] < root) {
            i++;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        return VerifySquenceOfBSTCore(sequence, 0, i - 1) && VerifySquenceOfBSTCore(sequence, i, end - 1);
    }


    //输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点
    //开始往下一直到叶结点所经过的结点形成一条路径。
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        FindPathDFS(root, target, result, list);
        return result;
    }

    private void FindPathDFS(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        FindPathDFS(root.left, target, result, list);
        FindPathDFS(root.right, target, result, list);
        list.remove(list.size() - 1);

    }


    //输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出
    //来的所有字符串 abc,acb,bac,bca,cab 和 cba 。
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str != null && str.length() != 0) {
            PermutationHelper(str.toCharArray(), 0, result);
            Collections.sort(result);
        }
        return result;
    }

    private void PermutationHelper(char[] str, int start, ArrayList<String> result) {
        if (start == str.length - 1) {
            if (!IsExist(result, str)) {
                result.add(new String(str));
            }
            return;
        }
        for (int i = start; i < str.length; i++) {
            swap(str, start, i);
            PermutationHelper(str, start + 1, result);
            swap(str, start, i);
        }
    }

    private boolean IsExist(ArrayList<String> result, char[] str) {
        return result.contains(String.valueOf(str));
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
