import java.util.Scanner;

public class TestExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = 0;
            if (n == 0) {
                return;
            }
            while (n >= 3) {
                sum += n/3;
                n = n/3 + n%3;
            }
            if (n == 2) {
                sum += 1;
            }
            System.out.println(sum);
        }
    }
}
