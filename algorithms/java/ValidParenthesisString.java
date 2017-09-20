/**
 * Created by Yang on 2017/9/19.
 ************************************************************************************************
 * Given a string containing only three types of characters: '(', ')' and '*', write a function
 * to check whether this string is valid. We define the validity of a string by these rules:
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an
 * empty string.
 * An empty string is also valid.
 *
 * Example 1:
 *  Input:  "()"
 *  Output: true
 *
 * Example 2:
 *  Input:  "(*)"
 *  Output: true
 *
 * Example 3:
 *  Input:  "(*))"
 *  Output: true
 *
 * Note:
 *      The string size will be in the range [1, 100].
 ************************************************************************************************
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int n = s.length();
        // dp[i][j] 表示， s[i...j]是有效的
        boolean[][] dp = new boolean[n][n];
        // 初始化长为1的有效子串
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                dp[i][i] = true;
            }
        }
        // 初始化长为2的有效子串
        for (int i = 0; i < n-1; i++) {
            if ((s.charAt(i) == '(' || s.charAt(i) == '*') && s.charAt(i+1) == ')' || s.charAt(i+1) == '*') {
                dp[i][i+1] = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i+len <= n; i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                    for (int j = i+1; j < i+len; j++) {
                        if ((s.charAt(j) == ')' || s.charAt(j) == '*')
                                && (j == i+1 || dp[i+1][j-1])
                                && (j == i+len-1 || dp[j+1][i+len-1])) {
                            dp[i][i+len-1] = true;
                            continue;
                        }
                    }
                }
            }
        }

        return dp[0][n-1];
    }
}
