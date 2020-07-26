



public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(15);
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(6);
        myLinkedList.display();
        System.out.println(myLinkedList.contains(15));
        System.out.println(myLinkedList.size());
        myLinkedList.addIndex(2, 8);
        myLinkedList.display();
        myLinkedList.remove(1);
        myLinkedList.display();
        myLinkedList.addLast(6);
        myLinkedList.display();
        myLinkedList.removeAllKey(6);
        myLinkedList.display();
        myLinkedList.clear();

    }
}
