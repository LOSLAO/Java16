import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    //数字分类
    //给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        int temp = 1;
        boolean find2 = false;
        int sum4 = 0;
        int count4 = 0;
        int A5 = 0;
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
            switch (array[i] % 5) {
                case 0:
                    if (array[i] % 2 == 0) {
                        A1 += array[i];
                    }
                    break;
                case 1:
                    find2 = true;
                    A2 += temp*array[i];
                    temp = (-1) * temp;
                    break;
                case 2:
                    A3++;
                    break;
                case 3:
                    sum4 += array[i];
                    count4++;
                    break;
                case 4:
                    if (A5 < array[i]) {
                        A5 = array[i];
                    }
                    break;
                default:
                    break;
            }
        }
        String A4 = "N";
        if (count4 > 0) {
            A4 = new DecimalFormat("0.0").format(sum4 * 1.0 / count4);
        }

        if (A1 == 0) {
            System.out.print("N" + " ");
        } else {
            System.out.print(A1 + " ");
        }
        if (find2) {
            System.out.print(A2 + " ");
        } else {
            System.out.print("N" + " ");
        }
        if (A3 == 0) {
            System.out.print("N" + " ");
        } else {
            System.out.print(A3 + " ");
        }
        System.out.print(A4 + " ");
        if (A5 == 0) {
            System.out.print("N");
        } else {
            System.out.println(A5);
        }

    }
}
