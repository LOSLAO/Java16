



public class MyStack {
    private int[] array = new int[100];
    private int size = 0;

    public void push(int v) {
        array[size++] = v;
    }

    public int pop() {
        return array[--size];
    }

    public int peek() {
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
