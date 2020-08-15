import java.util.Scanner;

public class Main1 {
    public static int NumSubString(int k, String str) {
        char[] array = str.toCharArray();
        int res = 0;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] == '1') {
                res++;
            }
        }
        if (res < k) {
            return 0;
        }
        res = 0;
        for (int i = 0; i < len; i++) {
            int index = i;
            int count = 0;
            while (count < k && index < len) {
                if (array[index] == '1' && ++count == k) {
                    res++;
                    index++;
                    break;
                }
                index++;
            }
            while (index < len && array[index] != '1') {
                res++;
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.next();
        System.out.println(NumSubString(k, str));
    }
}
