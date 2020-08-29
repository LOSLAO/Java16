import java.util.HashMap;
import java.util.Map;

public class Main {
    //定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
    public String originalDigits(String s) {
        char[] count = new char[26 + (int)'a'];
        for (char letter : s.toCharArray()) {
            count[letter]++;
        }
        int[] out = new int[10];
        // letter "z" is present only in "zero"
        out[0] = count['z'];
        // letter "w" is present only in "two"
        out[2] = count['w'];
        // letter "u" is present only in "four"
        out[4] = count['u'];
        // letter "x" is present only in "six"
        out[6] = count['x'];
        // letter "g" is present only in "eight"
        out[8] = count['g'];
        // letter "h" is present only in "three" and "eight"
        out[3] = count['h'] - out[8];
        // letter "f" is present only in "five" and "four"
        out[5] = count['f'] - out[4];
        // letter "s" is present only in "seven" and "six"
        out[7] = count['s'] - out[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'] - out[7] - 2 * out[9];

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < out[i]; j++) {
                output.append(i);
            }
        }
        return output.toString();

    }

    //给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
    //
    //我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
    //
    //所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
    //
    //请你返回「表现良好时间段」的最大长度。
    //
    public int longestWPI21(int[] hours) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int temp = hours[i] > 8 ? 1 : -1;
            sum += temp;
            if (sum > 0) {
                res = i + 1;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
                if (map.containsKey(sum - 1)) {
                    res = Math.max(res, i - map.get(sum - 1));
                }
            }
        }
        return res;
    }

    public int longestWPI2(int[] hours) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int temp = hours[i] > 8 ? 1 : -1;
            sum += temp;
            if (sum > 0) {
                res = i + 1;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum , i);
                }
                if (map.containsKey(sum - 1)) {
                    res = Math.max(res, i - map.get(sum - 1));
                }
            }
        }
        return res;
    }
}
