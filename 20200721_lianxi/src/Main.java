


public class Main {
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
            mid = (right + left) >> 1;
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
