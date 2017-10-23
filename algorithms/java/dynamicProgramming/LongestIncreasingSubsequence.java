package dynamicProgramming;

/**
 * Created by Yang on 2017/10/23.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length]; // dp[i]存储的是，到nums[i]（包括）为止，最长递增子序列的长度
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0; //到nums[i-1]为止，各字串中，将nums[i]附到最后，依然是递增序列的字串的最大长度
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {//将nums[i]附到最后，依然是递增序列
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1; //将nums[i]附到最后，增加了满足特定条件（for循环）的最大递增子序列的长度
            max = Math.max(max, dp[i]); //nums[i]位置，最大递增子序列的最大值不一定出现在dp[i]处
        }
        return max;
    }
}
