import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n < 20) {
            if (n % 15 == 0) {
                System.out.println(n);
                continue;
            }
            System.out.println("heheheheeh");
            n++;
        }
    }
}
