import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

public class TestDemo {
    //给定一个整型数组, 将所有的偶数放在前半部分, 将所有的奇数放在数组后半部分
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
            while (left < right && arr[right] %2 == 0) {
                right--;
            }
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }

        }
    }

    //数组逆序
    public static void main22(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    private static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    //冒泡排序

    public static void main21(String[] args) {
        int[] array = {1, 24, 3, 75, 66, 85, 23};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        boolean flg = false;
        for (int i = 0; i < array.length - 1; i++) {
            flg = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flg = true;
                }


            }
            if (flg == false) {
                break;
            }
        }
    }

    public static void main20(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(isSorted(array));

    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1 ]) {
                return false;
            }
        }
        return true;
    }

    public static void main19(String[] args) {
        int[] array = {1, 24, 3, 75, 66, 85, 23};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main18(String[] args) {
        int[] array = new int[10];
        Arrays.fill(array, 2, 5, 8);
        System.out.println(Arrays.toString(array));
    }
    public static void main17(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.equals(array, array2));

    }
    public static void main16(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] ret = Arrays.copyOfRange(array, 2, 5);
        System.out.println(Arrays.toString(ret));
        //System.out.println(Arrays.binarySearch(array, 2, 5, 4));
    }
    public static void main15(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.binarySearch(array, 3));
    }
    //二分查找
    public static void main14(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(array,4));
    }

    private static int binarySearch(int[] array, int toFind) {
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

    //查找数组中指定元素
    public static void main13(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(find(array, 3));
    }

    private static int find(int[] array, int toFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //求数组中元素的平均值
    public static void main12(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(avg(array));

    }

    private static double avg(int[] array) {
        int sum = 0;
        for (int x: array) {
            sum += x;
        }
        return (double)sum / (double)array.length;
    }

    //找数组当中的最大值
    public static void main11(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int ret = max(array);
        System.out.println(ret);
    }

    private static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    //数组的拷贝
    public static void main10(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] ret = array.clone();
        System.out.println(Arrays.toString(ret));
    }
    public static void main9(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] ret = new int[array.length];
        System.arraycopy(array, 0, ret,0, array.length);
        System.out.println(Arrays.toString(ret));
    }
    public static void main8(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] ret = copyArray2(array);
        System.out.println(Arrays.toString(ret));
    }

    private static int[] copyArray2(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }
        return ret;
    }

    public static void main7(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        copyArray(array);
    }

    private static void copyArray(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        System.out.println("newArray: " + Arrays.toString(newArray));
    }

    public static void main6(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(myString(array));
    }

    private static String myString(int[] array) {
         String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            if (i != array.length - 1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }

    public static void main5(String[] args) {
        int[] array = {18, 5, 7, 4, 6, 3, 2, 1};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main4(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] ret = func(array);
        System.out.println(Arrays.toString(ret));
    }

    private static int[] func(int[] array) {
        int[] tmp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = 2 * array[i];
        }
        return tmp;
    }


    public static void main3(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //将数组以字符串的形式输出
        System.out.println(Arrays.toString(array));
    }
    public static void main2(String[] args) {
        int[] array = {10, 20};
        System.out.println(array[0] + " " + array[1]);
        swap(array);
        System.out.println(array[0] + " " + array[1]);
    }

    private static void swap(int[] array) {
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }

    private static void printArray(int[] array) {
        for (int val: array) {
            System.out.print(val + " ");
        }
    }
    public static void main1(String[] args) {
        int[] array = {1, 2, 3, 4};
        printArray(array);
//        System.out.println(array.length);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
//        for (int val: array) {
//            System.out.print(val + " ");
//        }
    }


}
