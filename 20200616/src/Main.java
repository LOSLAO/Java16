import java.util.Scanner;

public class Main {

    //证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
    //解题思路:
    //观察规律，m的3次方可以表示成m个连续奇数的和。
    //m的2次方很明显是这m个连续奇数的平均数，
    //由此可以找到等式的开始数和结尾数
    //最后用StringBuffer类的变量和"+"将这m个数连接起来,就得到最终的结果。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int result = n*n*n;
            int mid = n*n;
            StringBuffer sb = new StringBuffer();
            int begin = mid + 1 - n;
            int end = mid - 1 + n;
            for (; begin <= end; begin += 2) {
                if (begin == end) {
                    sb.append(begin);
                    break;
                }
                sb.append(begin + "+");
            }
            System.out.println(sb.toString());
        }
        scanner.close();
    }

    //现给定数字，请编写程序输出能够组成的最小的数。
    //解题思路：找到所给数字中非零并且最小的数，让它为数字最高位，，然后将剩余元素从小到大依次添加。
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] num = new int[10];
            for (int i = 0; i < 10; i++) {
                num[i] = scanner.nextInt();
            }
            System.out.println(GetNum(num));
        }
    }

    private static String GetNum(int[] num) {
        String s = "";
        for (int i = 1; i < 10; i++) {
            if (num[i] != 0) {
                s += i;
                num[i]--;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            while (num[i] != 0) {
                s += i;
                num[i]--;
            }
        }
        return s;
    }
}
