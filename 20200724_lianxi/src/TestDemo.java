
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


public class TestDemo {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 0) {
            return null;
        }
        ListNode cur = head;
        ListNode prev = head;
        while (k > 0 && cur != null) {
            cur = cur.next;
            k--;
        }
        while (cur != null) {
            cur = cur.next;
            prev = prev.next;
        }
        return k > 0 ? null : prev;
    }

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
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return newHead.next;

    }

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

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
            result = IsSameFromBegin(root1, root2);
        }
        if (result != true) {
            result = HasSubtree(root1.left, root2);
        }
        if (result != true) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean IsSameFromBegin(TreeNode begin, TreeNode beginSub) {
        if (beginSub == null) {
            return true;
        }
        if (begin == null) {
            return false;
        }
        if (begin.val != beginSub.val) {
            return false;
        }
        return IsSameFromBegin(begin.left, beginSub.left) && IsSameFromBegin(begin.right, beginSub.right);
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode node = new ListNode(-1);
        ListNode cur = pHead;
        ListNode tmp = node;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return node.next;
    }




}
