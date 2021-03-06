/**
 * Created by Yang on 2017/7/31.
 ************************************************************************************************
 * Initially on a notepad only one character 'A' is present. You can perform two operations on
 * this notepad for each step:
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum
 * number of steps permitted. Output the minimum number of steps to get n 'A'.
 *
 * Example:
 *  Input: 3
 *  Output: 3
 *  Explanation:
 *      Intitally, we have one character 'A'.In step 1, we use Copy All operation.In step 2,
 *      we use Paste operation to get 'AA'.In step 3, we use Paste operation to get 'AAA'.
 *
 * Note:
 *      The n will be in the range [1, 1000].
 ************************************************************************************************
 */
public class TwoKeysKeyboard {
    /**
     * https://discuss.leetcode.com/topic/97590/java-dp-solution
     * https://discuss.leetcode.com/topic/97603/c-clean-code-with-explanation-4-lines-no-dp
     * It take 2 op to double, 3 ops to triple, ...
     * if n % 2 == 0, then f(n) = f(n/2) + 2
     * if n % 3 == 0, then f(n) = f(n/3) + 3
     * 2 * 2 = 2 + 2, 2 * 3 > 2 + 3, 4 * 4 > 4 + 4, so it is always better to divide whenever possible.
     * now it became a problem for finding all possible factors;
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j < i; j++) {
                if (0 == i % j) {
                    dp[i] = dp[i/j] + j;
                    break;
                }
            }
        }
        return dp[n];
    }
}
