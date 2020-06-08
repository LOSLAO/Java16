import java.util.Stack;

public class Main {
    //用两个栈实现队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        //出队列需要将栈1的元素全部弹进栈2， 然后弹出栈2的元素，实现反序
        //首先必须保证栈2是空的，里面没有元素干扰最终出列结果
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
