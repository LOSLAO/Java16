import java.util.Scanner;

public class TestDemo {
    //判断是否是回文
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(getAns(str.toCharArray(), 0, str.length()-1, false));
        }
    }

    private static boolean getAns(char[] arr, int start, int end, boolean flag) {
        if (end <= start) {
            return true;
        }
        if (arr[start] ==arr[end]) {
            return getAns(arr, start+1, end-1,flag);

        } else {
            if (flag) {
                return false;
            }
            return getAns(arr, start, end-1, true) || getAns(arr, start +1, end, true);
        }
    }
}
