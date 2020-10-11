import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestDemo2 {
    public boolean isValid1(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            Character top = stack.pop();
            if (top == '(' && c == ')') {
                continue;
            }
            if (top == '[' && c == ']') {
                continue;
            }
            if (top == '{' && c == '}') {
                continue;
            }
            return false;
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            Character top = stack.pop();
            if (top == '(' && c == ')') {
                continue;
            }
            if (top == '{' && c == '}') {
                continue;
            }
            if (top == '[' && c == ']') {
                continue;
            }
            return false;
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    Queue<Integer> A = new LinkedList<>();
    Queue<Integer> B = new LinkedList<>();

    public void push1(int x) {
        A.offer(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1) {
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        swapAB();
        return ret;
    }

    private void swapAB() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    public Integer top() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1) {
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }


}
