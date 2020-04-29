


public class MyQueue2 {
    private int[] array = new int[100];
    //[head, tail) 初始情况下队列中应该是没有元素的.
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    // 如果插入失败, 返回 false
    // 如果插入成功, 返回 true
    public boolean offer(int value) {
        if(size == array.length) {
            return false;
        }
        array[tail] = value;
        tail++;
        if(tail >= array.length) {
            tail = 0;
        }
        size++;
        return true;
    }

    public Integer poll() {
        if(size == 0) {
            return null;
        }
        int ret = array[head];
        head++;
        if(head >= array.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    public Integer peek() {
        if(size == 0) {
            return null;
        }
        return array[head];
    }

    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.offer(4);
        while (true) {
            Integer cur = myQueue2.poll();
            if (cur == null) {
                break;
            }
            System.out.println(cur);
        }
    }
}
