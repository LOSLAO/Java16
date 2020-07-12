import java.math.BigInteger;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BigInteger> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(new BigInteger(scanner.next()));
        }
        Collections.sort(list);
        for (BigInteger i : list) {
            System.out.println(i);
        }

    }


    //奇校验
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            jiCheck(str.toCharArray());
        }
    }

    private static void jiCheck(char[] arrs) {
        int[] result = new int[8];
        for (int i = 0; i < arrs.length; i++) {
            int num = 0x01;
            int count = 0;
            int index = 7;
            while (index > 0) {
                result[index] = ((arrs[i] & num) == 0) ? 0 : 1;
                if (result[index] == 1) {
                    count++;
                }
                num <<= 1;
                index--;
            }
            result[0] = (count % 2 == 1) ? 0 : 1;
            for (int j = 0; j < 8; j++) {
                System.out.print(result[j]);
            }
            System.out.println();

        }
    }
}
