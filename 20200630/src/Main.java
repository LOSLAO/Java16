import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //投票统计
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<String, Integer> map = new LinkedHashMap<String, Integer>();
            for (int i = 0 ; i < n; i++) {
                map.put(scanner.next(), 0);
            }
            int vote = scanner.nextInt();
            int invalid = 0;
            for (int j = 0; j < vote; j++) {
                String temp = scanner.next();
                if (map.get(temp) == null) {
                    invalid++;
                } else {
                    map.put(temp, map.get(temp) + 1);
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            System.out.println("Invalid : " + invalid);

        }
    }
    //对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = n * n;
            int sum1 = 0;
            int sum2 = 0;
            while (n > 0) {
                sum1 += n % 10;
                n = n / 10;
            }
            while (m > 0) {
                sum2 += m % 10;
                m = m / 10;
            }
            System.out.println(sum1 + " " + sum2);
        }
    }
}
