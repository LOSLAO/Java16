import java.util.Scanner;

public class Main {

    //对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
    public boolean chkParenthesis(String A, int n) {
        int left = 0;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return left == 0;
    }


    //读入一个字符串str，输出字符串str中的连续最长的数字串
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int max = 0;
            int count = 0;
            int end = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    count++;
                    if (max < count) {
                        max = count;
                        end = i;
                    }
                } else {
                    count = 0;
                }
            }
            System.out.println(str.substring(end - max + 1, end + 1));
        }
    }
}



