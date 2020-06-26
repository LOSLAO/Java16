import java.util.Scanner;

public class Main {
    //洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。
    //法二：预测位置法
    // * 每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出
    // * 根据当前数的位置，可以算出经过一次洗牌后的位置
    // * 如果当前数小于等于n（即在左手），则他下次出现的位置是 1 + (当前位置 - 1) * 2 也就是 2*当前位置-1
    // * 如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[2 * n];
            for (int i = 1; i <= 2 * n; i++) {
                int index = i;
                for (int j = 0; j < k; j++) {
                    if (index <= n) {
                        index = 2 * index - 1;
                    } else {
                        index = (index - n) * 2;
                    }
                }
                arr[index - 1] = scanner.nextInt();
            }
            int i;
            for (i = 0; i < 2 * n - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[i]);
        }
    }

}
