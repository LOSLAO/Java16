import java.util.ArrayList;
import java.util.Scanner;

public class TestDemo {
    //反转句子
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String result = reverse(str);
            System.out.println(result);
        }
    }

    private static String reverse(String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i] + " ");
        }
        return sb.toString().trim();

    }

    //输入两个字符串，从第一字符串中删除第二个字符串中所有的字符
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> list = new ArrayList<>();
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            for (int i = 0; i < str1.length(); i++) {
                if (!(str2.contains(str1.charAt(i) + ""))) {
                    list.add(str1.charAt(i));
                }
            }
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + "");
            }
        }
    }
}
