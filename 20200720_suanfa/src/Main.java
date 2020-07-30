import java.util.Scanner;

public class Main {
    //在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按
    //照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否
    //含有该整数。

    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (target < array[i][j]) {
                j--;
            } else if (target > array[i][j]) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    //输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    //例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    //NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) >> 1;
            if (array[left] == array[right] && array[left] == array[mid]) {
                int result = array[left];
                for (int i = left + 1; i < right; i++) {
                    if (array[i] < result) {
                        result = array[i];
                    }
                }
                return result;
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];
    }

    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                int temp = array[i];
                int j = i;
                while (j > k) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[k++] = temp;
            }
        }

    }

}
