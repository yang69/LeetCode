package dynamicProgramming;

/**
 * Created by Yang on 2017/10/9.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null && t == null) {
            return 1;
        }
        if (s == null) {
            return 0;
        }
        if (s.length() < t.length() || (s.length() == t.length() && !s.equals(t))) {
            return 0;
        }

        // dp[i][j]表示s[0...i-1],t[0...j-1]的不同子序列的数量
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();

        System.out.println(distinctSubsequences.numDistinct("rabbbit", "rabbit") + " <---> 3");
        System.out.println(distinctSubsequences.numDistinct("aaa", "a") + " <---> 3");
    }
}
