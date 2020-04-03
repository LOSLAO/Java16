import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

//数组举例的方式
public class TestDemo {

    //二维数组

    public static void main(String[] args) {
        //不规则 可以手动指定列数
        int[][] array = new int[2][];
        array[0] = new int[]{1,2,3};
        array[1] = new int[]{4,5,6,7,8};
        System.out.println(Arrays.deepToString(array));
    }

    public static void main12(String[] args) {
        //规则：知道行列
        int[][] array = new int[2][3];
        int[][] array2 = new int[][] {{1,2,3}, {4,5,6}};
        int[][] array3 = new int[][] {{1,2}, {3,4}, {5,6}};

        for (int i = 0; i < array2.length ; i++) {
            for (int j = 0; j < array2[i].length ; j++) {
                System.out.print(array2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(array2));
    }

    //给定一个整型数组, 将所有的偶数放在前半部分, 将所有的奇数放在数组后半部分

    public static void transform(int[] array) {
        int left = 0;
        int right = array.length-1;
        while(left<right) {
            while(left < right && array[left] % 2 == 0) {
                left++;
            }
            while(left < right && array[right] % 2 != 0) {
                right--;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }

    public static void main11(String[] args) {
        int[] array = {2,3,8,7};
        transform(array);
        System.out.println(Arrays.toString(array));
    }

    //给定一个数组, 将里面的元素逆序排列

    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length-1;
        while(left<right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main10(String[] args) {
        int[] array = {1,2,3,4,5};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }



    // 数组排序(冒泡排序)

    public static void bubbleSort(int[] array) {
        boolean flg = false;
        for (int i = 0; i < array.length ; i++) {
            flg = false;
            for (int j = 0; j < array.length-1-i ; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
            if(flg == false) {
                return;
            }
        }
    }

    public static void main9(String[] args) {
        int[] array = {3,8,6,12,10};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    //给定一个整型数组, 判断是否该数组是有序的(升序)

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length-1 ; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main8(String[] args) {
        int[] array = {1,2,3,24,5,6};
        System.out.println(isSorted(array));
    }

    public static void main7(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int[] array2 = {1,2,3,4,5,6};

        //两个数组当中的内容是否相同
        System.out.println(Arrays.equals(array1, array2));
    }

    public static void main6(String[] args) {
        int[] array = {1,2,15,3,18,20};
        Arrays.sort(array);//对数组进行排序
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.binarySearch(array, 18));

    }

    //查找数组中指定元素(二分查找)
    public static int binarySearch(int[] array,int key) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (left+right) / 2;
            if(key < array[mid]) {
                right = mid - 1;
            } else if(key > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main5(String[] args) {

        int[] arr = {1,2,3,4,5,6};
        System.out.println(binarySearch(arr, 6));

    }

    //查找数组中指定元素(顺序查找)

    public static int findNum(int[] array,int num) {

        for (int i = 0; i < array.length ; i++) {
            if(array[i] == num) {
                return i;
            }
        }
        return -1;
    }
    public static void main4(String[] args) {
        int[] array = {1,2,3,4};
        int n = findNum(array,2);
        System.out.println(n);
    }

    //求数组中元素的平均值

    public static double avg(int[] array) {
        double sum = 0;
        for (int x:array) {
            sum += x;
        }
        return sum/array.length;
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5};
        double n = avg(array);
        System.out.println(n);
    }


    //找数组中的最大元素

    public static int maxOfArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length ; i++) {
            if(max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
    public static void main2(String[] args) {
        int[] array = {1,20,3,55,5,6};
        int n = maxOfArray(array);
        System.out.println(n);
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6};
        //拷贝范围[from to)
        //一般在Java中看到的from....to.....的范围一般都是左闭右开
        int[] ret = Arrays.copyOfRange(array,1,4);
        System.out.println(Arrays.toString(ret));
    }


}
