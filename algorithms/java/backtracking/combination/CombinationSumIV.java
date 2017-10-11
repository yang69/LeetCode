package backtracking.combination;

/**
 * Created by Yang on 2017/10/5.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();

        System.out.println(combinationSumIV.combinationSum4(new int[]{1,2,3}, 4) + " <---> 7");
    }
}
