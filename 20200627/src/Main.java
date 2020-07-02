import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问
    //解题基本思路
    //（1）设置两动态数组，分别存放学生的数目和操作的数目。
    //2）动态数组存放学生成绩。
    //（3）根据字符执行查询或是更新操作。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            int[] data = new int[2];
            data[0] = scanner.nextInt();
            data[1] = scanner.nextInt();
            ArrayList<Integer> array = new ArrayList<Integer>();
            for (int i = 0; i < data[0]; i++) {
                array.add(scanner.nextInt());
            }
            int time = 0;
            char a;
            int b,c;
            while (time < data[1]) {
                a = scanner.next().charAt(0);
                b = scanner.nextInt();
                c = scanner.nextInt();

                if (a == 'Q') {
                    int start, end;
                    if (b < c) {
                        start = b - 1;
                        end = c - 1;
                    } else {
                        start = c - 1;
                        end = b - 1;
                    }
                    int max = array.get(start);
                    for (int index = start + 1; index <= end; index++) {
                        if (max < array.get(index)) {
                            max = array.get(index);
                        }
                    }
                    System.out.println(+max);
                    max = 0;
                }
                if (a == 'U') {
                    int index1 = b - 1;
                    int newValue = c;
                    array.set(index1, newValue);
                }
                time++;
            }
            }
            while (scanner.hasNext());
            scanner.close();
        }




        

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(energy(n, a, b));
        }
    }

    private static int energy(int n, int a, int[] b) {
        for (int i = 0; i < n; i++) {
            if (a >= b[i]) {
                a += b[i];
            } else {
                a += maxCommonNum(b[i], a);
            }
        }
        return a;
    }

    private static int maxCommonNum(int m, int n) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        if (m % n == 0) {
            return n;
        } else {
            return maxCommonNum(n, m%n);
        }
    }
}
