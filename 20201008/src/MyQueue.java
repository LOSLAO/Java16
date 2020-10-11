


class Node {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    Node(int val) {
        this(val, null);
    }
}

public class MyQueue {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void offer(int v) {
        Node newNode = new Node(v);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        return;
    }

    public Integer poll() {
        if (head == null) {
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;

    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
