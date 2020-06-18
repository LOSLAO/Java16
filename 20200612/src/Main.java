
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] B = new int[A.length];
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            int res = 1;
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    tmp = A[j];
                    A[j] = 1;
                    res *= A[j];
                    A[j] = tmp;
                } else {
                    res *= A[j];
                }
            }
            B[i] = res;
        }
        return B;

    }




    //统计不同个位数出现的次数
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(0);
        }
        for (int i = 0; i < chars.length; i++) {
            list.set(chars[i] - '0', list.get(chars[i] - '0') + 1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                System.out.println(i + ":" + list.get(i));
            }
        }
    }
}
