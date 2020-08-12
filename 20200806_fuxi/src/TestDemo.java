import java.util.Stack;

public class TestDemo {
    // 括号匹配问题
    public boolean isValid1(String s) {
        if (s.isEmpty()) {
            return true;
        }
        //1.创建一个栈
        Stack<Character> stack = new Stack<>();
        //2.循环遍历字符串，取出字符看是左括号还是右括号
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是左括号就入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            //如果是右括号，取栈底元素，和当前括号是否匹配
            if (stack.empty()) {
                return false;
            }
            Character top = stack.pop();
            //判断是否匹配
            if (top == '(' && c == ')') {
                continue;
            }
            if (top == '{' && c == '}') {
                continue;
            }
            if (top == '[' && c == ']') {
                continue;
            }
            //三个情况都没有匹配，剩下的就是非法情况了
            return false;
        }
        //最后一步，当字符串遍历结束后，看栈是否为空
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public boolean isValid2(String s) {
        if (s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
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


}
