class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}


public class Main {
    //输入一个链表，反转链表后，输出新链表的表头
    //解法一
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = newHead;
            newHead = cur;
        }
        return newHead;
    }


    //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    //解法一：
    public ListNode Merge1(ListNode headA,ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            } else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA == null) {
            tmp.next = headB;
        }
        if (headB == null) {
            tmp.next = headA;
        }
        return newHead.next;
    }

    //解法二:
    public ListNode Merge(ListNode headA,ListNode headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        ListNode newHead = null;
        if (headA.val < headB.val) {
            newHead = headA;
            headA = headA.next;
        } else {
            newHead = headB;
            headB = headB.next;
        }
        newHead.next = Merge(headA, headB);
        return newHead;
    }



    //输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
            result = isSameFromBegin(root1, root2);
        }
        if (result != true) {
            result = HasSubtree(root1.left, root2);
        }
        if (result != true) {
            result = HasSubtree(root1.right, root2);
        }
        return result;

    }

    private boolean isSameFromBegin(TreeNode begin, TreeNode beginSub) {
        if (beginSub == null) {
            //说明比较完了
            return true;
        }
        if (begin == null) {
            //说明beginSub不是子树
            return false;
        }
        if (begin.val != beginSub.val) {
            //说明没有相等的节点
            return false;
        }
        return isSameFromBegin(begin.left, beginSub.left) && isSameFromBegin(begin.right, beginSub.right);
    }



    //操作给定的二叉树，将其变换为源二叉树的镜像
    public void Mirror(TreeNode root){
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例
    //如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead){
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next = null;
        return node.next;
    }

}
