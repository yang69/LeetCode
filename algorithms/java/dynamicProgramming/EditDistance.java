package dynamicProgramming;

/**
 * Created by Yang on 2017/10/7.
 */
public class EditDistance {
//    https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]表示将word1[0...i-1]转换到word2[0...j-1]的最少步骤
        // dp[i][j] = dp[i - 1][j - 1], if word1[i - 1] = word2[j - 1];
        // dp[i][j] = min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1), otherwise.
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // 需要i次删除
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // 需要j次插入
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1,
                            Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();

        System.out.println(editDistance.minDistance("", "") + " <---> 0");
        System.out.println(editDistance.minDistance("vnaidfh", "vqbvridu") + " <---> 6");
    }
}
