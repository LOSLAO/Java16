import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("-");
            n = -n;
        }
        while (n != 0) {
            int tmp = n % 10;
            System.out.println(tmp);
            n = n / 10;
        }
    }
    public static void main10(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 31; i >= 1; i -= 2) {
            System.out.print(((n >>> i) & 1) + " ");
        }
        System.out.println();
        for (int i = 32; i >= 0; i-=2) {
            System.out.print(((n >>> i) & 1) + " ");
        }
    }
    public static void main9(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;
        }
        System.out.println(count);
    }
    public static void main8(String[] args) {
        for (int i = 0; i <= 999999; i++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0) {
                count++;
                tmp = tmp / 10;
            }
            tmp = i;
            int sum = 0;
            while (tmp != 0) {
                sum += Math.pow(tmp % 10, count);
                tmp = tmp / 10;
            }
            if (sum == i) {
                System.out.println(sum + "要找的数字");
            }
        }
    }
    public static void main7(String[] args) {
        for (int i = 0; i <= 999999; i++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0) {
                count++;
                tmp = tmp / 10;
            }
            tmp = i;
            int sum = 0;
            while (tmp != 1) {
                sum +=  Math.pow(i % 10, count);
                tmp = tmp / 10;
            }
            if (sum == i) {
                System.out.println(sum + "是要找的数字!");
            }
        }
    }
    public static void main6(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 9) {
                count++;
            }
            if (i / 10 == 9) {
                count++;
            }
        }
        System.out.println(count);

    }
    public static void main5(String[] args) {
        double sum = 0;
        int flg = 1;
        for (int i = 1; i <= 100; i++) {
            sum = sum + 1.0 / flg * i;
            flg = -flg;
        }
        System.out.println(sum);
    }
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        System.out.println("最大公约数" + b);
    }
    public static void main3(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            int tmp = 1;
            for (int j = 1; j<= i; j++) {
                tmp *= j;
            }
            sum += tmp;
        }
        System.out.println("sum + " + sum);
    }
    public static void main2(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            int tmp = 1;
            for (int j = 1; j <= i; j++) {
                tmp *= j;
            }
            sum += tmp;
        }
        System.out.println("sum = " + sum);
    }
    public static void main1(String[] args) {
        int a = 10;
        int b = ++a;
        System.out.println(b);
        int c = a++;
        System.out.println(c);
    }
}
