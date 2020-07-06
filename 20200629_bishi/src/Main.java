import java.util.Scanner;

public class Main {
    //写程序求出某人A的总评绩点（GPA）。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] array = new int[a];
        double[] grade = new double[a];
        double sumArray = 0;
        for (int i = 0; i < a; i++) {
            int b = scanner.nextInt();
            array[i] = b;
            sumArray += b;
        }
        for (int i = 0; i < a; i++) {
            int b = scanner.nextInt();
            grade[i] = b;
        }
        change(grade);
        double sum = 0;
        for (int i = 0; i < a; i++) {
            sum += array[i] * grade[i];
        }
        double GPA = sum / (sumArray * 1.0);
        System.out.printf("%.2f", GPA);
        System.out.println();
    }


        private static void change ( double[] grade){
            for (int i = 0; i < grade.length; i++) {
                double a = grade[i];
                grade[i] = calculation(a);
            }
        }

        private static double calculation (double i){
            double point = 0;
            if (i >= 90 && i <= 100) {
                point = 4.0;
            } else if (i >= 85 && i <= 89) {
                point = 3.7;
            } else if (i >= 82 && i <= 84) {
                point = 3.3;
            } else if (i >= 78 && i <= 81) {
                point = 3.0;
            } else if (i >= 75 && i <= 77) {
                point = 2.7;
            } else if (i >= 72 && i <= 74) {
                point = 2.3;
            } else if (i >= 68 && i <= 71) {
                point = 2.0;
            } else if (i >= 64 && i <= 67) {
                point = 1.5;
            } else if (i >= 60 && i <= 63) {
                point = 1.0;
            } else if (i < 60) {
                point = 0;
            }
            return 0;
        }
    }

