import java.util.Arrays;
import java.util.Stack;

public class Sort {
    //1.插入排序
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            //处理bound位置的元素如何插入
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    //tmp元素还需要往前查找，同时就需要把cur位置的元素往后搬运
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    //2.希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    //3.选择排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    // 以 bound 位置的元素作为擂台.
                    // 拿当前元素和擂台上的元素进行 pk.
                    // pk 赢了就进行交换. 当前是升序排序, 谁小, 谁就赢了
                    swap(array, cur, bound);
                }
            }
        }
    }

    //4.堆排序
    public static void heapSort(int[] array) {
        //1.先建立堆
        creatHeap(array);
        int heapSize = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            // 2. 交换堆顶元素和堆中的最后一个元素
            swap(array, 0, heapSize - 1);
            // 3. 把最后一个元素从堆中删除掉
            heapSize--;
            // 4. 针对当前的堆从 根节点 开始进行向下调整
            shiftDown(array, heapSize, 0);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }

    }

    private static void creatHeap(int[] array) {
       for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
           shiftDown(array, array.length, i);
       }
    }

    //5.冒泡排序
    public static void bubbleSort(int[] array) {
        // 从后往前遍历, 每次找最小元素放前面
        // [0, bound), 已排序区间
        // [bound, size), 待排序区间
        for (int bound = 0; bound < array.length; bound++) {
            // 接下来就需要在待排序区间中找到当前的最小值.
            // 具体的找法就是, 比较相邻元素, 看是否符合升序要求, 不符合就交换元素
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array, cur - 1, cur);
                }
            }
        }
    }

    //6.快速排序
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }
    // [left, right] 前闭后闭区间. 针对当前范围进行快速排序
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            // 1. 先从左往右找到一个大于基准值的元素
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            // 此时 i 指向的位置要么和 j 重合, 要么就是一个比基准值大的元素
            // 2. 再从右往左找到一个小于基准值的元素
            while (i < j && array[j] >= baseValue) {
                j--;
            }
            // 此时 j 指向的元素要么和 i 重合, 要么就是比基准值小的元素
            // 3. 交换 i 和 j 的值
            if (i < j) {
                swap(array, i, j);
            }
        }
        // 当整个循环结束, i 和 j 就重合了. 接下来就把 基准值 位置的元素交换到 i j 重合位置上.
        // 此时 i 和 j 重合位置的元素一定是大于基准值的元素.
        swap(array, i, right);
        return i;
    }

    //非递归实现快速排序
    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left >= right) {
                continue;
            }
            int index = partition(array, left, right);
            stack.push(index + 1);
            stack.push(right);
            stack.push(left);
            stack.push(index - 1);
        }
    }

    //7.归并排序
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        // 针对 [left, right) 区间, 分成对等的两个区间
        int mid = (left + right) / 2;
        // [left, mid)
        // [mid, right)
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        // 通过上面的递归, 认为这两个区间都被排好序了. 接下来就可以进行合并了
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        // 临时空间需要能容纳下 两个数组合并后的结果
        int[] output = new int[right - left];
        int outputIndex = 0;
        while (cur1 < mid && cur2 < right) {
            if (array[cur1] < array[cur2]) {
                // 把 cur1 位置的元素插入到 output 中
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
        // 最后一步要把数据从临时空间中拷贝回原来的数组中.
        for (int i = 0; i < right - left; i++) {
            array[left + i] = output[i];
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
        //quickSortByLoop(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
