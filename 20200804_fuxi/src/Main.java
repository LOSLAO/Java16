import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                queue.offer(input[i]);
            } else {
                if (input[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            int start = 0;
            int count = 0;
            int end = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                    count++;
                    if (start < count) {
                        start = count;
                        end = i;
                    }
                } else {
                    count = 0;
                }
            }
            System.out.println(string.substring(end - start + 1, end + 1));
        }
    }
}
