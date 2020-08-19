import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKeyBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String expected = scanner.next();
            String actual = scanner.next();
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                set.add(actual.charAt(i));
            }
            Set<Character> brokenKey = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (set.contains(c)) {
                    continue;
                }
                if (brokenKey.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKey.add(c);
            }
            System.out.println();
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String expected = scanner.next();
            String actual = scanner.next();
            expected = expected.toUpperCase();
            actual = expected.toUpperCase();

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                set.add(actual.charAt(i));
            }

            Set<Character> brokenKey = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (set.contains(c)) {
                    continue;
                }
                if (brokenKey.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKey.add(c);
            }
            System.out.println();
        }


    }
}
