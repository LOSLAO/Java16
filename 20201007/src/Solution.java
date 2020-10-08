class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int data) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

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

    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
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

    public ListNode partition(ListNode pHead, int x) {
        ListNode as = null;
        ListNode ae = null;
        ListNode bs = null;
        ListNode be = null;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                if (bs == null) {
                    bs = cur;
                    be = bs;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                if (as == null) {
                    as = cur;
                    ae = as;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            return as;
        }
        be.next = as;
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }

    public ListNode deleteDuplication(ListNode pHead) {
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
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return node.next;


    }

    public boolean chkPalindrome(ListNode A) {
        if (A == null) {
            return false;
        }
        if (A.next == null) {
            return true;
        }
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (slow != A) {
            if (slow.val != A.val) {
                return false;
            }
            if (A.next == slow) {
                return true;
            }
            slow = slow.next;
            A = A.next;
        }
        return true;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode PL = headA;
        ListNode PS = headB;
        while (PL != null) {
            lenA++;
            PL = PL.next;
        }
        while (PS != null) {
            lenB++;
            PS = PS.next;
        }
        PL = headA;
        PS = headB;
        int len = lenA - lenB;
        if (len < 0) {
            PL = headB;
            PS = headA;
            len = lenB - lenA;
        }
        while (len > 0) {
            PL = PL.next;
            len--;
        }
        while (PL != PS) {
            PL = PL.next;
            PS = PS.next;
        }
        if (PL == PS && PL != null && PS != null) {
            return  PL;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
