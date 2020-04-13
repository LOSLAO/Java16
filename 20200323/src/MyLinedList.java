
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}
public class MyLinedList {

    public Node head;

    public MyLinedList() {
        this.head = null;
    }

//头插法:1.首先需要拿到一个Node
//      2.把它插入到head前面

    public void addFirst(int data) {
        Node node = new Node(data);

        if(this.head == null) {
            //第一次插入节点
            this.head =node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
//尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;


    }
//任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data) {
        if(index < 0 || index > size()) {
            throw new RuntimeException("Index位置不合法");
        }
        if (index == 0) {
            addFirst(data);
            return ;
        }
        if(index == size()) {
            addLast(data);
            return ;
        }
        Node prev = findIndex(index);
        Node node = new Node(index);
        node.next = prev.next;
        prev.next = node;



    }
    private Node findIndex(int index) {
        Node cur = this.head;
        int count = 0;
        while(count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
//查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //找到关键字key的前驱
    private Node findPrev(int key) {
        Node prev = this.head;
        while(prev.next != null) {
            if(prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }
//删除第一次出现关键字为key的节点
    public void remove(int key) {
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = findPrev(key);
        if(prev == null) {
            System.out.println("没有这个节点");
            return;
        }
        Node del = prev.next;
        prev.next = del.next;

    }
//删除所有值为key的节点
    public void removeAllKey(int key) {
        Nodeprev = this.head;
        Node cur = this.head.next;

        while(cur != null) {
            if(ur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }
//得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count =0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data+" ");
            cur = cur.next;
        }
    }
    public void clear() {
        

    }

}
