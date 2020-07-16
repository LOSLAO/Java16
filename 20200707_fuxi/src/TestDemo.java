


public class TestDemo {
    //求n的阶乘


    //计算 1! + 2! + 3! + 4! + 5!
    public static void main(String[] args) {
        System.out.println(factor(5));
    }

    private static int factor(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fac(i);
        }
        return sum;
    }

    private static int fac(int num) {
        int ret = 1;
        for (int i = 1; i <= num; i++) {
            ret *= i;
        }
        return ret;
    }
}
