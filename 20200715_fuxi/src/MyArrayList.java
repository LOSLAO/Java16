import java.util.Arrays;

public class MyArrayList {
    private int[] elem;
    private int usedSize;

    private static final int DEFAULT_SIZE = 3;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    //打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    //在pos位置新增元素
    public void add(int pos, int data) {
        if (isFull()) {
            grow();
        }
        check(pos);
        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;

    }

    private boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }

    private void check(int pos) {
        if (pos < 0 || pos > this.usedSize) {
            throw new ArrayIndexOutOfBoundsException("pos位置不合法");
        }
    }

    private void grow() {
        this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
    }

    //判定是否包含某个元素
    public boolean contains(int toFind) {
        if (isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;

    }

    private boolean isEmpty() {
        if (this.usedSize == 0) {
            return true;
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind) {
        if (isEmpty()) {
            throw new RuntimeException("顺序表为空");
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos) {
        if (isEmpty()) {
            throw new RuntimeException("顺序表为空！");
        }
        check(pos);
        return this.elem[pos];
    }

    //删除第一次出现的关键字key
    public void remove(int key) {
        int index = search(key);
        if (index == -1) {
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }

    //获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

}
