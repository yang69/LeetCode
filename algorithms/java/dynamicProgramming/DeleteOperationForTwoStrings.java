package dynamicProgramming;

/**
 * Created by Yang on 2017/10/8.
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]表示，word1[0...i-1]和word[0...j-1]相等所需要的删除的数量
        // if (word1[i-1] == word2[j-1]), dp[i][j] = dp[i-1][j-1]
        // else, dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1])
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }


    public int minDistanceUsingLCS(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] longestCommonSubsequence = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    longestCommonSubsequence[i][j] = 1 + longestCommonSubsequence[i-1][j-1];
                } else {
                    longestCommonSubsequence[i][j] = Math.max(longestCommonSubsequence[i][j-1], longestCommonSubsequence[i-1][j]);
                }
            }
        }

        return m + n - 2 * longestCommonSubsequence[m][n];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings deleteOperationForTwoStrings = new DeleteOperationForTwoStrings();

        System.out.println(deleteOperationForTwoStrings.minDistance("sea", "eat")
                + " <---> " + deleteOperationForTwoStrings.minDistanceUsingLCS("sea", "eat"));
    }
}
