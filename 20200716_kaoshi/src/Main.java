import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        findIndex(arr);
    }

    private static void findIndex(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer x : arr) {
            int m = map.getOrDefault(x, 0);
            map.put(x, m + 1);
        }
        for (Map.Entry<Integer, Integer> k:map.entrySet()) {
            if (k.getValue()%2==1) {
                System.out.println(k.getKey() + " ");
            }
        }
        System.out.println();
    }
}
