import java.util.Arrays;

public class Sort {
    //1.插入排序
    //以升序排序位列
    public static void insertSort(int[] array) {
        //有序区间 [0, bound)
        //无序空间 [bound, size)
        for (int bound = 1; bound < array.length; bound++) {
            //处理bound位置的元素如何往前进行插入
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    //tmp元素还需要往前去找，同时就需要把cur位置的元素往后搬运
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
        //当gap为1的时候，再来一次最终插排
        insertSortGap(array, 1);
    }
    //分组情况下，同组的相邻元素下标差为gap
    private static void insertSortGap(int[] array, int gap) {
        //从每组的[1]的元素开始
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap; //bound位置中相邻的前一个元素下标
            for (; cur >= 0; cur -= gap) {
                if(array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void main1(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
