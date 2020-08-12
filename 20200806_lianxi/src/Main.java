import java.util.Stack;

public class Main {
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


}
