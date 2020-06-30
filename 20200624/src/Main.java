import java.util.Scanner;

public class Main {
    //密文转换问题
    //思路：
    //首先判断输入的字符 是A到E的话，那么就给这个字符加上21，否则就直接加上5。最后再将修改后的值放回数组中。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        char[] b = a.toCharArray();
        for (int i = 0; i < b.length; i++) {
            char c = b[i];
            if (c - 'A' >= 0) {
                c = (char)(c > 'E' ? (c - 5) : (c + 21));
                b[i] = c;
            }
        }
        System.out.println(new String(b));
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int monthCount = scanner.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
    }

    private static int getTotalCount(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
    }
}
