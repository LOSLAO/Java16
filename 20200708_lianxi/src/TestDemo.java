import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array, 4));

    }
    public static int binarySearch(int[] array, int toFind) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < array[mid]) {
                right = mid - 1;
            } else if (toFind > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main7(String[] args) {
        int[] array = {9, 5, 2, 7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void main6(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        reverse(array);
        System.out.println(Arrays.toString(array));

    }

    private static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main5(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        transform(array);
        System.out.println(Arrays.toString(array));

    }

    private static void transform(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 == 0) {
                left++;
            }
            while (left < right && array[right] % 2 != 0) {
                right--;
            }
            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
    }

    public static void main4(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] ret = array.clone();
        System.out.println(Arrays.toString(ret));
    }
    public static void main3(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] ret = new int[array.length];
        System.arraycopy(array, 0, ret, 0, array.length);
        System.out.println(Arrays.toString(ret));
    }
    public static void main2(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        copyArray(array);
    }

    private static void copyArray(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        System.out.println("newArray: " + Arrays.toString(newArray));
    }

    public static void main1(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] ret = copyArray1(array);
        System.out.println(Arrays.toString(ret));
    }

    private static int[] copyArray1(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }
        return ret;
    }
}
