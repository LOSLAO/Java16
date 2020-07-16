

public class TestDemo2 {

    // 求解汉诺塔问题(提示, 使用递归)
    public static void move(char pos1, char pos2) {
        System.out.print(pos1 + "->" + pos2 + " ");
    }
    public static void hanoi(int n, char pos1, char pos2, char pos3) {
        if (n == 1) {
            move(pos1, pos3);
        } else {
            hanoi(n - 1, pos1, pos3, pos2);
            move(pos1, pos3);
            hanoi(n - 1, pos2, pos1, pos3 );
        }
    }
    public static void main5(String[] args) {
        hanoi(1, 'A', 'B', 'C');
        System.out.println();
        hanoi(2, 'A', 'B', 'C');
        System.out.println();
        hanoi(3, 'A', 'B', 'C');


    }
    //写一个递归方法，输入一个非负整数，返回组成它的数字之和. 例如，输入 1729, 则应该返回1+7+2+9，
    //它的和是19
    public static void main4(String[] args) {
        int ret = sum(1729);
        System.out.println(ret);
    }

    private static int sum(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sum(n / 10);
    }

    //递归求 1 + 2 + 3 + ... + 10
    public static void main3(String[] args) {
        int ret = sum1(10);
        System.out.println(ret);
    }

    private static int sum1(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum1(n - 1);
    }

    //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
    public static void main2(String[] args) {
        print(1234);
    }
    public static void print(int num) {
        if (num > 9) {
            print(num / 10);
        }
        System.out.println(num % 10);
    }
    //递归求n的阶乘
    public static void main1(String[] args) {
        System.out.println(fac(5));
    }

    private static int fac(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fac(n - 1);
    }

    public static void main6(String[] args) {
        int a = 10;
        int b = 20;
        int ret = add(a, b);
        System.out.println(ret);
    }

    private static int add(int x, int y) {
        return x + y;
    }

    public static void main7(String[] args) {
        int a = 10;
        int b = 20;
        swap(a, b);
        System.out.println("a=" + a + "b=" + b);
    }

    private static void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }

    public static void main(String[] args) {
        int ret = fib(5);
        System.out.println(ret);
    }
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
