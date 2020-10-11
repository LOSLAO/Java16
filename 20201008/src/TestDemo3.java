import java.util.Stack;

public class TestDemo3 {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    public void push(int x) {
        while (!B.empty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        A.push(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (!A.empty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.pop();
    }

    public Integer peek() {
        if (empty()) {
            return null;
        }
        while (!A.empty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
