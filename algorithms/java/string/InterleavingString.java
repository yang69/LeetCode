package string;

import java.util.HashMap;

/**
 * Created by Yang on 2017/10/9.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        }
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        // dp[i][j] 表示，isInterleave(s1[0...i-1], s2[0...j-1], s3[0...i+j-1])是否为真
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1)) {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j-1) == s3.charAt(j-1)) {
                dp[0][j] = dp[0][j-1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s3.charAt(i+j-1)) {
                    dp[i][j] |= dp[i-1][j];
                }
                if (s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }

    public boolean isInterleaveBruteForce(String s1, String s2, String s3) {
        return isInterleaveBruteForce(s1, 0, s2, 0, "", s3);
    }

    private boolean isInterleaveBruteForce(String s1, int to1, String s2, int to2, String res, String s3) {
        if (res.equals(s3) && to1 == s1.length() && to2 == s2.length()) {
            return true;
        }
        boolean ans = false;
        if (to1 < s1.length()) {
            ans |= isInterleaveBruteForce(s1, to1 + 1, s2, to2, res + s1.charAt(to1), s3);
        }
        if (to2 < s2.length()) {
            ans |= isInterleaveBruteForce(s1, to1, s2, to2 + 1, res + s2.charAt(to2), s3);
        }
        return ans;
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();

        System.out.println(interleavingString.isInterleave("", "", "")
                + " <---> " + interleavingString.isInterleaveBruteForce("", "", ""));
        System.out.println(interleavingString.isInterleave("aabd", "abdc", "aabdbadc")
                + " <---> " + interleavingString.isInterleaveBruteForce("aabd", "abdc", "aabdbadc"));
        System.out.println(interleavingString.isInterleave("a", "", "a")
                + " <---> " + interleavingString.isInterleaveBruteForce("a", "", "a"));
    }
}
