/**
 * Created by Yang on 2017/8/29.
 ************************************************************************************************
 * Given an integer array with all positive numbers and no duplicates, find the number of
 * possible combinations that add up to a positive integer target.
 *
 * Example 1:
 *  Input:  nums = [1, 2, 3], target = 4
 *  Output: 7
 *  Explanation:
 *      The possible combination ways are:
 *      (1, 1, 1, 1)
 *      (1, 1, 2)
 *      (1, 2, 1)
 *      (1, 3)
 *      (2, 1, 1)
 *      (2, 2)
 *      (3, 1)
 *      Note that different sequences are counted as different combinations.
 ************************************************************************************************
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] 和为i的组合数
        int[] dp = new int[target + 1];
        // 初始化，只取nums中的一个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < dp.length) {
                dp[nums[i]] = 1;
            }
        }
        // 对于和为i的组合，在其后添加num，便成为和为i+num的组合
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i + nums[j] <= target) {
                    dp[i + nums[j]] += dp[i];
                }
            }
        }

        return dp[target];
    }

    /**
     * 对前一方法的改进，省去循环中的判断
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum41(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // 保证target - 1 + max 不会溢出，那么就可以省去循环中的判断
        int[] dp = new int[target + max];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = 1;
        }
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i + nums[j]] += dp[i];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();

        System.out.print(combinationSumIV.combinationSum4(new int[]{1,2,3}, 4) + " <---> ");
        System.out.println(combinationSumIV.combinationSum41(new int[]{1,2,3}, 4));
    }
}
