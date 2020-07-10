import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str.contains(".")) {
                String[] arr = str.split("\\.");
                long[] ip = new long[arr.length];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    ip[i] = Long.parseLong(arr[i]);
                    String a = Long.toBinaryString(ip[i]);
                    String temp = String.format("%08d", Long.parseLong(a));
                    sb.append(temp);
                }
                long output = Long.parseLong(sb.toString(), 2);
                System.out.println(output);
            } else {
                String binaryChuan = Long.toBinaryString(Long.parseLong(str));
                int len = binaryChuan.length();
                StringBuilder sb = new StringBuilder(binaryChuan);
                for (int i = 0; i < 32 - len; i++) {
                    sb.insert(0, "0");
                }
                String fin = sb.toString();
                long a = Long.valueOf(fin.substring(0, 8), 2);
                long b = Long.valueOf(fin.substring(8, 16), 2);
                long c = Long.valueOf(fin.substring(16, 24), 2);
                long d = Long.valueOf(fin.substring(24, 32), 2);
                System.out.println(a + "." + b + "." + c + "." + d);
                System.out.println();


            }
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int i = 0;
        for (i = 0; i < n; i++) {
            int m = scanner.nextInt();
            arr[i] = m;
        }
        int a = scanner.nextInt();
        System.out.println(search(arr, a));
    }

    public static int search(int[] arr, int a) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                return i;
            }
        }
        return -1;
    }
}
