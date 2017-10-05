package sum;

import java.util.Arrays;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 * 找到和为target的数
 *  1. Two Sum(数组中，和为target的两个数，用HashMap)
 *  15. 3Sum（数组中，和为target的3个数，先排序，再用双指针）
 *  18. 4Sum（数组中，和为target的4个数，先排序，再依次转化为3Sum和2Sum问题）
 *  454. 4Sum II（4个数组中，分别取1个数，其中和为0的取法的个数，转换为2组2个数的和互为相反数，用HashMap）
 *  167. Two Sum II - Input array is sorted(排序数组中，和为target的两个数，用双指针)
 *  653. Two Sum IV - Input is a BST(二叉查找树中，和为target的两个数，用HashSet)
 ************************************************************************************************
 * Given an array S of n integers, find three integers in S such that the sum is closest to a
 * given number, target. Return the sum of the three integers. You may assume that each input
 * would have exactly one solution.
 *
 * Example:
 *  Input:  S = {-1 2 1 -4}, and target = 1.
 *  Output: 2.
 *  Explanation:
 *      The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 ************************************************************************************************
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length-2; i++) {
            int lo = i + 1;
            int hi = nums.length-1;
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                int gap = sum - target;
                if( Math.abs(gap) < Math.abs(minGap) ) {
                    minGap = gap;
                }
                if(gap < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return minGap + target;
    }
}
