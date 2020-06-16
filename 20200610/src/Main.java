import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //有一个数组a[NJ顺序存放0~N-1,要求每隔两个数删掉一个数， 到末尾时循环至开 头继续进行，求最后- -个被删掉的数的原始下标位置。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            System.out.println(delete(arr));
        }
        scanner.close();
    }

    private static int delete(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (queue.size() != 1) {
            int count = 0;
            while (count != 2) {
                queue.add(queue.peek());
                queue.poll();
                count++;
            }
            queue.poll();
        }
        return queue.element();
    }
}


