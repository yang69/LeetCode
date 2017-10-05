package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 * 找到和为target的数
 *  1. Two Sum(数组中，和为target的两个数，用HashMap)
 *  15. 3Sum（数组中，和为target的3个数，先排序，再用双指针）
 *  16. 3Sum Closest（数组中，和最接近于target的3个数，输出其和，先排序，再用双指针）
 *  454. 4Sum II（4个数组中，分别取1个数，其中和为0的取法的个数，转换为2组2个数的和互为相反数，用HashMap）
 *  167. Two Sum II - Input array is sorted(排序数组中，和为target的两个数，用双指针)
 *  653. Two Sum IV - Input is a BST(二叉查找树中，和为target的两个数，用HashSet)
 ************************************************************************************************
 * Given an array S of n integers, are there elements a, b, c, and d in S such that
 * a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Example:
 *  Input:  S = [1, 0, -1, 0, -2, 2], and target = 0.
 *  Output: [
 *              [-1,  0, 0, 1],
 *              [-2, -1, 1, 2],
 *              [-2,  0, 0, 2]
 *          ]
 *  Explanation:
 *      nums[0] + nums[1] = 2 + 7 = 9
 *
 * Note:
 *      The solution set must not contain duplicate quadruplets.
 ************************************************************************************************
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length < 4) { //输入个数不足
            return res;
        }

        Arrays.sort(nums);

        int max = nums[nums.length-1];
        if( 4*nums[0] > target || 4*max < target) { //无解
            return res;
        }

        int i, z;
        for(i = 0; i < nums.length; i++) {
            z = nums[i];
            if(i > 0 && nums[i-1] == z) { //去重
                continue;
            }
            if(z + 3*max < target) { //z太小，无解
                continue;
            }
            if(4*z > target) { //z太大，无解。搜索结束
                break;
            }
            if(4*z == target) {
                if(i+3 < nums.length && nums[i+3] == z) {
                    res.add(Arrays.asList(z, z, z, z));
                }
                break; //接下去的z都太大，无解。搜索至此已经结束
            }
            threeSumForFourSum(nums, target-z, i+1, nums.length-1, res, z);
        }
        return res;
    }

    private void threeSumForFourSum(int[] nums, int target,
                                    int low, int high, List<List<Integer>> res, int z1) {
        if(low + 1 >= high) { //待处理的数列个数不足
            return;
        }

        int max = nums[high];
        if(3*nums[low] > target || 3*max < target) { //无解
            return;
        }

        int i, z;
        for(i = low; i < high-1; i++) { //结尾2个数不需要迭代
            z = nums[i];
            if(i > low && nums[i-1] == z) { //去重
                continue;
            }
            if(z + 2*max < target) { //z太小，无解
                continue;
            }
            if(3*z > target) { //z太大，无解。搜索结束
                break;
            }
            if(3*z == target) {
                if(i + 1 < high && nums[i+2] == z) {
                    res.add(Arrays.asList(z1, z, z, z));
                }
                break;
            }
            twoSumForFourSum(nums, target-z, i+1, high, res, z1, z);
        }
    }

    private void twoSumForFourSum(int[] nums, int target,
                                  int low, int high, List<List<Integer>> res, int z1, int z2) {
        if(low >= high) { //待处理的数组元素个数不足
            return;
        }

        if(2*nums[low] > target || 2*nums[high] < target) { //无解
            return;
        }

        int i = low, j = high, sum, temp;
        while(i < j) {
            sum = nums[i] + nums[j];
            if(sum == target) {
                res.add(Arrays.asList(z1, z2, nums[i], nums[j]));
                temp = nums[i];
                while(++i < j && temp == nums[i]) { //去重
                    ;
                }
                temp = nums[j];
                while(--j > i && temp == nums[j]) { //去重
                    ;
                }
            }
            if(sum < target) {
                i++;
            }
            if(sum > target) {
                j--;
            }
        }
        return;
    }
}
