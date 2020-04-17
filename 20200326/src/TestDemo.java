

public class TestDemo {
    public static void main(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(1);
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.addLast(5);
        myLinedList.display();
        System.out.println(myLinedList.contains(3));
        System.out.println(myLinedList.size());
        myLinedList.removeAllKey(2);
        myLinedList.display();
    }
}
