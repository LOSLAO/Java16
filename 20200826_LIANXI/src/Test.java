import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main1(String[] args) {
        String s = "祝你考出好成绩! ";
        System.out.println(s.length());
    }

    //对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count = 0;
        int i = 0, j = 0;
        for (; i < arr1.length && arr1[i] <= arr2[0]; i++) {
            if (Math.abs(arr1[i] - arr2[0]) > d) {
                count++;
            }
        }
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[i]) {
                if (Math.abs(arr1[i] - arr2[j]) > d && Math.abs(arr1[i] - arr2[j - 1]) > d) {
                    count++;
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        for (; i < arr1.length; i++) {
            if (Math.abs(arr1[i] - arr2[arr2.length - 1]) > d) {
                count++;
            }
        }
        return count;
    }

    //给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个
    // 元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
    // 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出
    //
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length );
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 8, 4, 1, 2};
        int[] ret = nextGreaterElements(nums);
        System.out.println(Arrays.toString(ret));
    }

    public int[] nextGreaterElements1(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }


}
