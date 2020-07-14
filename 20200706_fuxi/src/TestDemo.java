import java.util.Scanner;

public class TestDemo {
    //11.获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
    public static void main12(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 31; i >= 1; i -= 2) {
            System.out.print(((n>>i) & 1) +" ");
        }
        for (int i = 30; i >= 0; i -= 2) {
            System.out.println(((n>>i) & 1) + " ");
        }
    }
    //10.写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
    public static void main11(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;

        }
        System.out.println("count: " + count);
    }
    public static void main10(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n>>i) & 1) == 1) {
                count++;
            }
        }
        System.out.println("count: " + count);
    }
    //9.编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
    //入，最多输入三次。三次均错，则提示退出程序
    public static void main9(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 3;

        while (count != 0) {
            System.out.println("请输入你的密码: ");
            String password = scanner.nextLine();
            if (password.equals("123456")) {
                System.out.println("密码正确，登陆成功!");
                break;
            } else {
                count--;
                System.out.println("你还有"+count+"次机会!");
            }
        }
    }
    //8.求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
    //身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
    public static void main8(String[] args) {
        for (int n = 1; n < 999999; n++) {
            int count = 0;
            int tmp = n;
            while (tmp != 0) {
                tmp = tmp / 10;
                count++;
            }
            tmp = n;
            int sum = 0;
            while (tmp != 0) {
                sum += Math.pow(tmp%10, count);
                tmp = tmp/10;
            }
            if (sum == n) {
                System.out.println(sum + " is my result ");
            }
        }
    }


    //7.编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static void main7(String[] args) {
        int count = 0;
        for (int i = 1; i < 100; i++) {
            if (i / 10 == 9) {
                count++;
            } else if (i % 10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }
    //6.计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        double sum = 0;
        int flg = 1;
        for (int i = 0; i < n; i++) {
            sum = sum + 1.0/i * flg;
            flg = -flg;
        }
        System.out.println(sum);
    }
    //5.求两个正整数的最大公约数
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = 0;
        while (a % b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
    //4.输出乘法口诀表
    public static void main4(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i*j + " ");
            }
            System.out.println();
        }
    }
    //3.输出 1000 - 2000 之间所有的闰年
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int year = 1000; year <= n; year++) {
            if (year % 1000 != 0 && year % 4 == 0 || year % 400 == 0) {
                System.out.println(year + " 是闰年! ");
            }
        }
    }
    //2.打印1-100之间的素数

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            int j = 2;
            for (; j < (int)Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > (int)Math.sqrt(i)) {
                System.out.println(i + "是素数");
            }
        }
    }
    //1.判断一个数是不是素数
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 2; i < n/2; i++) {
            if (n % i == 0) {
                System.out.println(n + "不是素数！");
                break;
            }
        }
    }
}
