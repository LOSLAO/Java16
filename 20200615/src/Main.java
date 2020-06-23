import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    //请设计一个算法完成两个超长正整数的加法。
    public static String AddLongInteger(String addend,String augend){
        BigInteger a = new BigInteger("0");
        BigInteger bigInteger = new BigInteger(addend);
        BigInteger bigInteger1 = new BigInteger(augend);
        if (bigInteger.compareTo(a) > 0 && bigInteger1.compareTo(a) > 0) {
            bigInteger = bigInteger.add(bigInteger1);
            String str = String.valueOf(bigInteger);
            return str;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String addend = scanner.nextLine();
            String augend = scanner.nextLine();
            System.out.println(AddLongInteger(addend, augend));
        }
    }
    //输入在一行中给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int column = (int) Math.round(n / 2.0);
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == column - 1) {
                    System.out.print(str);
                } else {
                    if (j == 0 || j == n - 1) {
                        System.out.print(str);
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
