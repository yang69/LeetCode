package dynamicProgramming.knapsackProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Yang on 2017/8/27.
 ************************************************************************************************
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 背包问题（http://love-oriented.com/pack/）
 *  518. Coin Change 2（完全背包，和为target的集合共有多少种）
 ************************************************************************************************
 * Given a non-empty array containing only positive integers, find if the array can be
 * partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 *  Input:  [1, 5, 11, 5]
 *  Output: true
 *  Explanation:
 *      The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 *  Input:  [1, 2, 3, 5]
 *  Output: false
 *  Explanation:
 *      The array cannot be partitioned into equal sum subsets.
 *
 * Note:
 *      Each of the array element will not exceed 100.
 *      The array size will not exceed 200.
 ************************************************************************************************
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) != 0) {
            return false; // 和为奇数，无法划分为相等的两个子集
        }
        // dp[i][j] 表示，前i个数能否组合出和为j的集合
        boolean[][] dp = new boolean[nums.length + 1][sum/2+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true; // 空集（一个都不选）的和为0
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 对于第i个数，有选它或不选它两个选择
                dp[i][j] = dp[i-1][j] || (j - nums[i-1] >= 0 && j - nums[i-1] <= sum/2 && dp[i-1][j-nums[i-1]]);
            }
        }

        return dp[nums.length][sum/2];
    }

    public boolean canPartitionOpt(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) != 0) {
            return false; // 和为奇数，无法划分为相等的两个子集
        }
        // dp[j] 表示，能否组合出和为j的集合
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true; // 空集（一个都不选）的和为0
        for (int i = 1; i < nums.length; i++) {
            for (int j = dp.length-1; j >= 0; j--) {
                // 对于第i个数，有选它或不选它两个选择
                dp[j] = dp[j] || (j - nums[i-1] >= 0 && j - nums[i-1] <= sum/2 && dp[j-nums[i-1]]);
            }
        }

        return dp[sum/2];
    }

    /**
     * 穷举
     * @param nums
     * @return
     */
    public boolean canPartitionBruteForce(int[] nums) {
        List<Integer> lists = new ArrayList<>(nums.length);
        for (int n : nums) {
            lists.add(n);
        }
        HashSet<Integer> set = new HashSet<>(nums.length * 2);
        int sum = getSum(lists, 0, set);
        if ((sum & 1) == 0) {
            return set.contains(sum >> 1);
        }
        return false;
    }

    private int getSum(List<Integer> nums, int sum, HashSet<Integer> set) {
        if (nums.isEmpty()) {
            return sum;
        }
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i);
            nums.remove(i);
            set.add(sum + value);
            res = getSum(nums, sum + value, set);
            nums.add(i,value);
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();

        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,5,11,5})
                + " <---> " + partitionEqualSubsetSum.canPartitionOpt(new int[]{1,5,11,5})
                + " <---> " + partitionEqualSubsetSum.canPartitionBruteForce(new int[]{1,5,11,5}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,1,2})
                + " <---> " + partitionEqualSubsetSum.canPartitionOpt(new int[]{1,1,2})
                + " <---> " + partitionEqualSubsetSum.canPartitionBruteForce(new int[]{1,1,2}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,1})
                + " <---> " + partitionEqualSubsetSum.canPartitionOpt(new int[]{1,1})
                + " <---> " + partitionEqualSubsetSum.canPartitionBruteForce(new int[]{1,1}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,2,3,5})
                + " <---> " + partitionEqualSubsetSum.canPartitionOpt(new int[]{1,2,3,5})
                + " <---> " + partitionEqualSubsetSum.canPartitionBruteForce(new int[]{1,2,3,5}));
    }
}
