



public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList myLinkedList1 = new MyLinkedList();
        Node ret = getIntersectionNode(myLinkedList.head, myLinkedList1.head);
        System.out.println(ret);
    }
    public  static Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (headA != null && headB != null) {
            if (headA.data < headB.data) {
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
    public static Node getIntersectionNode(Node headA, Node headB){
        if (headA == null || headB == null) {
            return  null;
        }
        int lenA = 0;
        int lenB = 0;
        Node PL = headA;
        Node PS = headB;
        while (PL != null) {
            lenA++;
            PL = PL.next;
        }
        while (PS != null) {
            lenB++;
            PS = PS .next;
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
            PS = PS.next;
            PL = PL.next;
        }
        if (PL == PS && PL != null && PS != null) {
            return PL;
        }
        return null;

    }
}
