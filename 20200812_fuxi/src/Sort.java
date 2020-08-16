import java.util.Arrays;
import java.util.Stack;

public class Sort {
    // 以升序排序为例
    public static void insertSort(int[] array) {
        //有序区间【0， bound)
        //无序区间 [bound, size)
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    array[cur+1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    public static void insertSort1(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    public static void insertSort2(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    //希尔排序
    public static void shellSort(int[] array) {
        //gap=size/2, size/4, size/8 .....
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        //当gap = 1的时候再来一次最终插排
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

    public static void shellSort1(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap1(array, gap);
            gap = gap / 2;
        }
        insertSortGap1(array, 1);
    }

    private static void insertSortGap1(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp =array[bound];
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

    //选择排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            // 此时已经借助 bound 把数组分成两个区间了.
            // [0, bound) 已排序区间
            // [bound, size) 待排序区间
            // 接下来就需要在待排序区间中找到最小值, 放到 bound 位置上.
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    swap(array, cur, bound);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void selectSort1(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    swap(array, cur, bound);
                }
            }
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        //1.先建立堆
        createHeap(array);
        int heapSize = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            //2.交换堆顶和堆中的最后一个元素
            swap(array, 0, heapSize - 1);
            //3.把最后一个元素从堆中删除
            heapSize--;
            //4.针对当前的堆从根节点进行向下调整
            shiftDown(array, heapSize, 0);
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void heapSort1(int[] array) {
        createHeap(array);
        int heapSize = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            shiftDown(array, heapSize, 0);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        // 从后往前遍历, 每次找最小元素放前面
        // [0, bound), 已排序区间
        // [bound, size), 待排序区间
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array, cur - 1, cur);
                }
            }
        }
    }

    public static void bubbleSort1(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array, cur-1, cur);
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    // [left, right] 前闭后闭区间. 针对当前范围进行快速排序
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            // 区间中有 0 个元素或者 1 个元素
            return;
        }
        // 返回值表示 整理之后, 基准值所处在的位置.
        int index = partition(array, left, right);
        // [left, index - 1]
        // [index + 1, right]
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            //1.先从左往右找比基准值大的元素
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
        // 为啥 i 和 j 重合位置的元素一定大于基准值呢?
        // 1) i++ 触发了和 j 重合, 上次循环中刚把 i 和 j 交换元素. 交换之后 j 一定是一个大于基准值的元素. i 再往 j 上靠, 结果也一定是指向大于基准值的元素
        // 2) j-- 触发了和 i 重合, 此时 i 一定是指向一个大于基准值的元素(第一个 while 的功能)
        swap(array, i, right);
        return i;
    }

    public static void quickSort1(int[] array) {
        quickSortHelper1(array, 0, array.length - 1);
    }

    private static void quickSortHelper1(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition1(array, left, right);
        quickSortHelper1(array, left, index - 1);
        quickSortHelper1(array, index + 1, right);

    }

    private static int partition1(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            while (i < j && array[j] >= baseValue) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, i, right);
        return i;
    }

    //非递归实现快排
    public static void quickSortByLoop(int[] array) {
        // 栈中保存的元素相当于当前要进行 partition 操作的范围下标
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left >= right) {
                // 区间为空或者区间中只有一个元素. 此时不需要进行 partition 操作
                continue;
            }
            int index = partition(array, left, right);
            // 把右子树入栈 [index + 1, right]
            stack.push(index + 1);
            stack.push(right);
            //把左子树入栈 [left, index - 1]
            stack.push(left);
            stack.push(index - 1);
        }
    }

    public static void quickSortByLoop1(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (left >= right) {
                continue;
            }
            int index = partition2(array, left, right);
            stack.push(left);
            stack.push(index - 1);
            stack.push(index + 1);
            stack.push(right);
        }
    }

    private static int partition2(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[i] <= baseValue) {
                i++;
            }
            while (i < j && array[j] >= baseValue) {
                j--;
            }
            if ( i < j) {
                swap(array, i , j);
            }
        }
        swap(array, i, right);
        return i;
    }

    //归并排序
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        // [left, right)
        if (right - left <= 1) {
            //// 当前区间中有 0 个或者 1 个元素. 不需要进行排序
            return;
        }

        // 针对 [left, right) 区间, 分成对等的两个区间
        int mid = (left + right) / 2;
        // 两个区间分别就是
        // [left, mid)
        // [mid, right)
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        // 通过上面的递归, 认为这两个区间都被排好序了. 接下来就可以进行合并了
        merge(array, left, mid, right);

    }

    private static void merge(int[] array, int left, int mid, int right) {
        // 当前有两个有序数组
        // [left, mid)
        // [mid, right)
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right - left];
        int outputIndex = 0;//代表当前output中被插入了几个元素

        while (cur1 < mid && cur2 < right) {
            if (array[cur1] <= array[cur2]) {
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
        for (int i = 0; i < right - left; i++) {
            array[left + i] = output[i];
        }
    }

    public static void mergeSort1(int[] array) {
        mergeSortHelper1(array, 0, array.length);
    }

    private static void mergeSortHelper1(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper1(array, left, mid);
        mergeSortHelper1(array, mid, right);
        merge1(array, left, mid, right);
    }

    private static void merge1(int[] array, int left, int mid, int right) {
        int cur1 = left;
        int cur2 = mid;
        int[] output = new int[right - left];
        int outputIndex = 0;
        while (cur1 < mid && cur2 < right) {
            if (array[cur1] < array[cur2]) {
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
        for (int i = 0; i < right - left; i++) {
            array[left + 1] = output[i];
        }
    }

    //非递归归并排序
    public static void mergeSortByLoop(int[] array) {
        //gap表示当前每个组中的元素个数
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int i = 0; i < array.length; i += 2*gap) {
                // 每次执行一遍循环体, 相当于把两个长度为 gap 的相邻组进行了合并
                // [i, i + gap)
                // [i + gap, i + 2 * gap)
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
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
        //quickSortByLoop(array);
        //quickSortByLoop1(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
