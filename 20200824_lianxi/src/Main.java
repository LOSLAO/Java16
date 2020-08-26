import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
    public int findKthNum(int[] arr1, int[] arr2, int kth) {
        int i = 0;
        int j = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int k = 0;
        int res = 0;
        while (i < len1 && j < len2 && k < kth) {
            if (arr1[i] < arr2[j]) {
                res = arr1[i];
                i++;
            } else {
                res = arr2[j];
                j++;
            }
            k++;
        }
        while (i < len1 && k < kth) {
            res = arr1[i];
            i++;
            k++;
        }
        while (j < len2 && k < kth) {
            res = arr2[j];
            j++;
            k++;
        }
        return res;
    }

    public int findKthNum1(int[] arr1, int[] arr2, int kth) {
        int i = 0, j = 0, lenA = arr1.length, lenB = arr2.length, k = 0;
        int res = 0;
        while (i < lenA && j < lenB && k < kth) {
            if (arr1[i] < arr2[j]) {
                res = arr1[i];
                i++;
            } else {
                res = arr2[j];
                j++;
            }
            k++;
        }
        while (i < lenA && k < kth) {
            res = arr1[i];
            i++;
            k++;
        }
        while (j < arr2[j] && k < kth) {
            res = arr2[j];
            j++;
            k++;
        }
        return res;
    }

    //两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        for (int num : nums1) {
            parentSet.add(num);
        }
        for (int num : nums2) {
            if (parentSet.contains(num)) {
                childSet.add(num);
            }
        }
        int[] res = new int[childSet.size()];
        int index = 0;
        for (int value : childSet) {
            res[index++] = value;
        }
        return res;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        for (int num : nums1) {
            parentSet.add(num);
        }
        for (int num : nums2) {
            if (parentSet.contains(num)) {
                childSet.add(num);
            }
        }
        int[] res = new int[childSet.size()];
        int index = 0;
        for (int value : childSet) {
            res[index++] = value;
        }
        return res;
    }

    //隐藏个人信息
    public String maskPII(String S) {
        int atIndex = S.indexOf('@');
        if (atIndex >= 0) {
            //就是email
            return (S.substring(0, 1) + "*****" + S.substring(atIndex - 1)).toLowerCase();

        } else {
            //电话号码
            String digital = S.replaceAll("\\D+", "");
            String local = "***-***-" + digital.substring(digital.length() - 4);
            if (digital.length() == 10) {
                //本地
                return local;
            }
            String ans = "+";
            for (int i = 0; i < digital.length() - 10; ++i) {
                ans += "*";
            }
            return ans + "-" + local;
        }
    }

    public String maskPII1(String S) {
        int atIndex = S.indexOf("@");
        if (atIndex >= 0) {
            return (S.substring(0, 1) + "*****" + S.substring(atIndex - 1)).toLowerCase();
        } else {
            String digital = S.replaceAll("\\D+", "");
            String local = "***-***-" + digital.substring(digital.length() - 4);
            if (digital.length() == 10) {
                return local;
            }
            String ans = "+";
            for (int i = 0; i < digital.length() - 10; ++i) {
                ans += "*";
            }
            return ans + "-" + local;
        }

    }

    public String maskPII2(String S) {
        int atIndex = S.indexOf("@");
        if (atIndex >= 0) {
            return (S.substring(0, 1) + "*****" + S.substring(atIndex - 1)).toLowerCase();
        } else {
            String digital = S.replaceAll("\\D+", "");
            String local = "***-***-" + digital.substring(digital.length() - 4);
            if (digital.length() == 10) {
                return local;
            }
            String res = "+";
            for (int i = 0; i < digital.length() - 10; ++i) {
                res += "*";
            }
            return res + "-" + local;
        }
    }

    // 有效的括号字符串
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                right.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!right.isEmpty()) {
                    right.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.pop() > right.pop()) {
                return false;
            }
        }
        return left.isEmpty();
    }

    public boolean checkValidString1(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                right.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!right.isEmpty()) {
                    right.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.pop() > right.pop()) {
                return false;
            }
        }
        return left.isEmpty();
    }

    //给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                boolean flg1 = true;
                boolean flg2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i);
                    char c4 = s.charAt(j);
                    if (c3 != c4) {
                        flg1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = s.charAt(i);
                    char c4 = s.charAt(i);
                    if (c3 != c4) {
                        flg2 = false;
                        break;
                    }
                }
                return flg1 || flg2;
            }
        }
    }

    public boolean validPalindrome1(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }

        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int i1) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
