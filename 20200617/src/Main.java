import java.util.Scanner;

public class Main {

    //  小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。
    public int MinChance(int x) {
        if (x % 1000000007 == 0) {
            return 0;
        }
        int count = 0;
        while (x != 0 && count <= 300000) {
            x = ((x << 1) + 1) % 1000000007;
            count++;
        }
        int result = (count + 2) / 3;
        return result > 100000 ? -1 : result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int pop = scanner.nextInt();
            int num = main.MinChance(pop);
            System.out.println(num);
        }
    }
    //给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
    public static int addAB(int A, int B) {
        if (A == 0) {
            return B;
        }
        if (B == 0) {
            return A;
        }
        int m = A^B;
        int n = (A&B) << 1;
        return addAB(m, n);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        System.out.println("返回: " + addAB(A, B));
    }
}
