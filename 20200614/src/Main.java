import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    //输出一个最小的步数变为Fibonacci数"
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 0;
        int b = 0;
        int c = 1;
        while (c < n) {
            a = b;
            b = c;
            c = a + b;
        }
        int n1 = n - b;
        int n2 = c - n;
        System.out.println(n1 < n2 ? n1 : n2);
    }
    //牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> result = new HashSet<>();
        while (scanner.hasNext()) {
            String s = scanner.next();
            result.add(s);
        }
        System.out.println(result.size());
        scanner.close();
    }
}
