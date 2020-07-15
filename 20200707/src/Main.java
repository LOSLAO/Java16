import java.util.Scanner;

public class Main {
    //输出0到n数字2出现的次数
    public int countNumberOf2s(int n) {
        int icCount = 0;
        int iFactor = 1;
        int iLowerNum = 0;
        int iCurrNum = 0;
        int iHigherNum = 0;
        while (n / iFactor != 0) {
            iLowerNum = n - (n / iFactor) * iFactor;
            iCurrNum = (n / iFactor) % 10;
            iHigherNum = n / (iFactor * 10);
        }
        switch (iCurrNum) {
            case 0 :
                icCount += iHigherNum * iFactor;
                break;
            case 1 :
                icCount += iHigherNum * iFactor;
                break;
            case 2 :


        }
    }
    //在霍格沃茨找零钱
    private static final int[] w = {17*29, 29, 1};
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] p = scanner.next().split("\\.");
        String[] a = scanner.next().split("\\.");
        int[] P = {Integer.parseInt(p[0]), Integer.parseInt(p[1]), Integer.parseInt(p[2])};
        int[] A = {Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2])};
        int ta = A[0] * w[0] + A[1] * w[1] + A[2] * w[2];
        int tp = P[0] * w[0] + P[1] * w[1] + P[2] * w[2];
        int t = ta - tp;
        if (ta < tp) {
            System.out.print("-");
            t = -t;
        }
        System.out.println(t/w[0] + "." + t%w[0]/w[1] + "." + t%w[0]%w[1]/w[2]);
    }
}
