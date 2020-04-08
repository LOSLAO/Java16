

public class TestDemo {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,10);
        myArrayList.add(1,20);
        myArrayList.add(2,30);
        myArrayList.add(3,40);
        myArrayList.display();
        System.out.println(myArrayList.getPos(2));
        System.out.println("删除");
        myArrayList.remove(40);
        myArrayList.display();
        myArrayList.clear();
        myArrayList.display();

    }
}
