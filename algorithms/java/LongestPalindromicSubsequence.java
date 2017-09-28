/**
 * Created by Yang on 2017/8/31.
 ************************************************************************************************
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that
 * the maximum length of s is 1000.
 *
 * Example 1:
 *  Input:  "bbbab"
 *  Output: 4
 *  Explanation:
 *      One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 *  Input:  "cbbd"
 *  Output: 2
 *  Explanation:
 *      One possible longest palindromic subsequence is "bb".
 ************************************************************************************************
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j]表示子字符串s[i...j]（包括i和j）中的最长回文子序列的长度
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();

        System.out.println(lps.longestPalindromeSubseq("bbbab") + " <---> 4");
        System.out.println(lps.longestPalindromeSubseq("cbbd") + " <---> 2");
    }
}
