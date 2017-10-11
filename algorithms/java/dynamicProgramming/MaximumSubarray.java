package dynamicProgramming;

/**
 * Created by Yang on 2017/10/6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // Dynamic programming:
        // dp[i]表示包含nums[i]的子序列的最大和
        // dp[i+1] = max(dp[i] + nums[i+1], nums[i+1])
        // 因为dp[i]是迭代计算的，所以只需要一个变量dp即可
        int res = nums[0], dp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp = dp > 0 ? dp + nums[i] : nums[i];
            res = Math.max(dp, res);
        }
        return res;
    }
}
