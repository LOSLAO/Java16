import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int L = scanner.nextInt();
            if (m == 1) {
                list.add(L);
            } else {
                int index = list.indexOf(L);
                list.remove(index);
            }
            if (list.size() < 3) {
                System.out.println("No");
            } else {
                Collections.sort(list, Collections.reverseOrder());
                int max = list.get(0);
                int sum = 0;
                for (int j = 1; j < list.size(); j++) {
                    sum += list.get(j);
                }
                if (sum > max) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int num = 0;
        int j = 0;
        int max = 0;

        List<Integer> list = new ArrayList<>();
        while (j++ < n) {
            int i = scanner.nextInt();
            int L = scanner.nextInt();
            scanner.nextLine();
            if (i == 1) {
                list.add(L);
                num += 1;
            } else {
                list.remove(list.indexOf(L));
                num -= 1;
            }
            Collections.sort(list);
            if (list.size() > 0) {
                max = list.get(list.size() - 1);
            }
            if (num - max <= max) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
