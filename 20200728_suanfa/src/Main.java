import java.util.ArrayList;

public class Main {
    //小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于
    //此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序
    //列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1;
        int high = 2;
        while (low < high) {
            int total = (low + high) * (high - low + 1)/2;
            if (total == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                low++;
            } else if (total < sum) {
                high++;
            } else {
                low++;
            }
        }
        return result;
    }

    //一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
    public void FindNumsAppearOnce(int[] array,int num1[], int num2[]) {
        if (array == null || num1 == null || num2 == null) {
            return;
        }
        num1[0] = 0;
        num2[0] = 0;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        int index = 1;
        while ((index & result) == 0) {
            index = index << 1;
        }
        for (int i = 0; i < array.length; i++) {
            if ((index & array[i]) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

}
