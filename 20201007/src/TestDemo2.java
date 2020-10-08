import java.util.Arrays;

public class TestDemo2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void transform(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    public static void main3(String[] args) {
        int[] arr = {1, 2, 3, 4};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main2(String[] args) {
        int ret = sum(1729);
        System.out.println(ret);
    }

    private static int sum(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sum(n / 10);
    }

    public static void main1(String[] args) {
        print(1234);
    }

    private static void print(int n) {
        if (n > 9) {
            print(n / 10);
        }
        System.out.print(n % 10);
    }
}
