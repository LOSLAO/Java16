import java.util.Arrays;
import java.util.Stack;

public class Sort {
    //非递归实现快速排序
    public static void quickSortByLoop(int[] array) {
        //栈中保存的元素相当于当前要进行partition操作的范围下标
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left >= right) {
                //区间为空或者区间中只有一个元素，此时不需要进行partition操作
                continue;
            }
            int index = partition(array, left, right);
            //把右子树入栈[index+1, right]
            stack.push(index + 1);
            stack.push(right);
            //把左子树入栈[left, index - 1]
            stack.push(left);
            stack.push(index - 1);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            while (i < j && array[j] > baseValue) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, i, right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //归并排序
    public static void mergeSort(int[] array) {
        //[0, length]
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        //[left, right)
        if (right - left <= 1) {
            return;
        }

        //针对[left, right]区间，分成对等的两个区间
        int mid = (right + left) / 2;
        //两个区间分别是
        //[left, mid)
        //[mid, right)
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        //通过上面的递归，认为这两个区间都被排好序了，接下来就可以进行合并了
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        //临时空间需要容纳下 两个数组合并后的结果
        int[] output = new int[right - left];
        int outputIndex = 0;//当前output中被插入了几个元素

        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
                //把cur1位置的元素插入到output中
                output[outputIndex] = array[cur1];
                cur1++;
                outputIndex++;
            } else {
                output[outputIndex] = array[cur2];
                cur2++;
                outputIndex++;
            }
        }
        while (cur1 < mid) {
            output[outputIndex] = array[cur1];
            cur1++;
            outputIndex++;
        }
        while (cur2 < right) {
            output[outputIndex] = array[cur2];
            cur2++;
            outputIndex++;
        }
        //最后一步要把数据从临时空间拷贝到原来的数组中
        for (int i = 0; i < right - left; i++) {
            array[left + i] = output[i];
        }
    }

    //非递归实现归并排序
    public static void mergeSortByLoop(int[] array) {
        //gap表示当前每个组中的元素个数
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int i = 0; i < array.length; i += 2*gap) {
                //每次执行一遍循环体，相当于把两个长度为gap的相领组进行了合并
                //[i, i+gap)
                //[i+gap, i+2*gap)
                int left = i;
                int mid = i + gap;
                int right = i + 2 * gap;
                if (mid > array.length) {
                    mid = array.length;
                }
                if (right > array.length) {
                    right = array.length;
                }
                merge(array, left, mid, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        //quickSortByLoop(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
