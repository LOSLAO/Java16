import java.util.Stack;

public class MyQueueByStack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    public void offer(int x) {
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        A.push(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.pop();
    }

    public Integer peek() {
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
