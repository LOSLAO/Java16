



public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0, 10);
        myArrayList.add(1, 20);
        myArrayList.add(2, 30);
        myArrayList.display();
        myArrayList.add(3, 50);
        myArrayList.display();
        System.out.println(myArrayList.contains(20));
        System.out.println(myArrayList.search(20));
        System.out.println(myArrayList.getPos(1));
        myArrayList.remove(10);
        myArrayList.display();
        System.out.println(myArrayList.size());
        myArrayList.clear();
        myArrayList.display();


    }
}
