

public class TestDemo {
    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(1);
        myLinedList.addLast(2);
        myLinedList.addLast(3);
        myLinedList.addLast(4);
        myLinedList.addFirst(5);

        myLinedList.display();
        System.out.println(myLinedList.contains(14));
        System.out.println(myLinedList.size());


    }
}
