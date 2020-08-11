


public class MyQueueByLinkedList {
    static class Node {
        public int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head = null;
    private Node tail = null;
    //此处按照尾部入队列，头部出队列
    //入队列offer
    public void offer(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            tail = newNode;
            head = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
    }

    //出队列
    public Integer poll() {
        if (head == null) {
            return -1;
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            //删除当前元素之后，队列变成了空的队列
            tail = null;
        }
        return ret;
    }

    //取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
