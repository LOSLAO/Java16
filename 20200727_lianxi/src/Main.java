import java.util.Stack;

public class Main {


    //将字符串反转的方法
    //第一种 递归方法
    public static String reverse1(String str) {
        if (str.length() <= 1) {
            return str;
        }
        String left = str.substring(0, str.length()/2);
        String right = str.substring(str.length()/2, str.length());
        return reverse(right) + reverse(left);
    }

    //第二种：StringBuffer
    public static String reverse2(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    //第三种：利用栈
    public static String reverse3(String str) {
        char[] array = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(array[i]);
        }
        String rev = "";
        for (int i = 0; i < str.length(); i++) {
            rev += stack.pop();
        }
        return rev;
    }

    //第四种：把字符串倒着遍历拼接返回
    public static String reverse(String str) {
        char[] array = str.toCharArray();
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += array[i];
        }
        return rev;
    }


    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(reverse1(str));
        System.out.println(reverse2(str));
        System.out.println(reverse3(str));
        System.out.println(reverse(str));


    }
}
