import java.util.Scanner;

public class Main {
    //输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] arr1 = s1.split("");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr1.length; i++) {
            if (!s2.contains(arr1[i])) {
                sb.append(arr1[i]);
            }
        }
        System.out.println(sb.toString());
    }


    //输入一个整数n,表示小易想购买n(1 <n< 100)个苹果
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(buyApple(n));
    }

    private static int buyApple(int n) {
        if (n < 6 || n%2 != 0 || n == 10) {
            return -1;
        }
        if (n%8 == 0) {
            return n/8;
        }
        return n/8 + 1;
    }
}
