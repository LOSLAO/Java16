

class Student {
    public String name;
    public String sex;
}


public class MyArrayList<E> {
    private E[] array = (E[])new Object[100];
    private int size;

    public void add(E o) {
        array[size] = o;
        size++;
    }

    E get(int index) {
        return array[index];
    }

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("haha");
        String s = myArrayList.get(0);

        MyArrayList<Student> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(new Student());
        Student student = myArrayList2.get(0);
    }
}
