public class TestDemo {
    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(1);
        myLinedList.addLast(2);
        myLinedList.addLast(3);
        myLinedList.addLast(4);
        myLinedList.addLast(5);


        Node ret = myLinedList.reverseList();
        myLinedList.display2(ret);

    }

    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while(headA != null && headB != null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else{
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA != null) {
            tmp.next = headA;
        }
        if(headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

    //输入两个链表，找出它们的第一个公共结点。
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;

        Node PL = headA;
        Node PS = headB;

        while(PL != null) {
            lenA++;
            PL = PL.next;
        }

        while(PS != null) {
            lenB++;
            PS = PS.next;
        }
        PL = headA;
        PS = headB;

        int len  = lenA-lenB;
        if(len < 0) {
            PL = headB;
            PS = headA;
            len = lenB-lenA;
        }
        while(len > 0) {
            PL = PL.next;
            len--;
        }
        while(PL != PS) {
            PL = PL.next;
            PS = PS.next;
        }
        if(PL==PS && PL != null) {
            return PL;
        }
        return null;

    }
}
