import java.util.Set;

public class Main {

    public boolean wordBreak(String s, Set<String> dict) {
        //给定一个字符串和一个词典dict，确定s是否可以根据词典中的词分成
        // 一个或多个单词。
        // 比如，给定
        // s = "leetcode"
        // dict = ["leet", "code"]
        // 返回true，因为"leetcode"可以被分成"leet code"
        //方法：动态规划
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                // F(i): true{j <i && F(j) && substr[j+1,i]能在词典中找到} OR false
                // 第j+1个字符的索引为j
                if (canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    public boolean wordBreak1(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    //https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/
    //如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
    //
    //我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
    //
    //返回使 S 单调递增的最小翻转次数。
    public int minFlipsMonoIncr(String S) {
        int count = 0;
        int[] dp = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                dp[i] = (i == 0 ? 0 : Math.min(dp[i - 1], count + 1));
                count++;
            } else {
                dp[i] = (i == 0 ? 0 : Math.min(dp[i - 1] + 1, count));
            }
        }
        return dp[S.length() - 1];
    }

    public int minFlipsMonoIncr1(String S) {
        int count = 0;
        int len = S.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '1') {
                dp[i] = (i == 0 ? 0 : Math.min(dp[i - 1], count + 1));
                count++;
            } else {
                dp[i] = (i == 0 ? 0 : Math.min(dp[i - 1] + 1, count));
            }
        }
        return dp[S.length() - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }
}
