import java.util.Scanner;

public class Main {

    //输入一个整数，将这个整数以字符串的形式逆序输出
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        System.out.println(sb.toString());
    }
    //输入一个正整数n,求n!(即阶乘)末尾有多少个0
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            n /= 5;
            count += n;
        }
        System.out.println(count);
    }
}
