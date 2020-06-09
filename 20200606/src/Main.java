import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int bigThanHalf(Integer[] arr, int n) {
        List<Integer> list = Arrays.asList(arr);
        HashSet<Integer> set = new HashSet<>(list);
        for (Integer i: set) {
            int count = 0;
            for (int j : set) {
                if (j == i) {
                    count++;
                }
            }
            if (count >= (n/2)) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] str = s.split(" ");
            Integer[] arr = new Integer[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(bigThanHalf(arr, arr.length));
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y1, y2, y3, y4;
        float a, b, c;
        while (scanner.hasNext()) {
            y1 = scanner.nextInt();
            y2 = scanner.nextInt();
            y3 = scanner.nextInt();
            y4 = scanner.nextInt();
            a = (y1 + y3)/2;
            b = (y3 - y1)/2;
            c = (y4 - y2)/2;
            if ((a - ((y1 + y3)/2) != 0)) {
                System.out.println("No");
                return;
            }
            if ((b - ((y3 - y1)/2)) != 0 || b != ((y2 + y4)/2)) {
                System.out.println("No");
                return;
            }
            if ((c - ((y4 - y2)/2)) != 0) {
                System.out.println("No");
                return;
            }
            System.out.println((int)a + " " + (int)b + " " + (int)c);
        }
    }
}
