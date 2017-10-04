package sum;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 找到和为target的数
 *  1. Two Sum(数组中，和为target的两个数，用HashMap)
 *  653. Two Sum IV - Input is a BST(二叉查找树中，和为target的两个数，用HashSet)
 ************************************************************************************************
 * Given an array of integers that is already sorted in ascending order, find two numbers such
 * that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the
 * target, where index1 must be less than index2. Please note that your returned answers (both
 * index1 and index2) are not zero-based. You may assume that each input would have exactly one
 * solution and you may not use the same element twice.
 *
 * Example:
 *  Input:  nums={2, 7, 11, 15}, target=9
 *  Output: [1, 2].
 ************************************************************************************************
 */
public class TwoSumII {
    public int[] twoSum(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi) {
            while (nums[lo] + nums[hi] < target) {
                lo++;
            }
            while (nums[lo] + nums[hi] > target) {
                hi--;
            }
            if (nums[lo] + nums[hi] == target && lo != hi) {
                return new int[]{lo + 1, hi + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}
