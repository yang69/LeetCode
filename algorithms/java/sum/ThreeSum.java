package sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 * 找到和为target的数
 *  1. Two Sum(数组中，和为target的两个数，用HashMap)
 *  16. 3Sum Closest（数组中，和最接近于target的3个数，输出其和，先排序，再用双指针）
 *  18. 4Sum（数组中，和为target的4个数，先排序，再依次转化为3Sum和2Sum问题）
 *  454. 4Sum II（4个数组中，分别取1个数，其中和为0的取法的个数，转换为2组2个数的和互为相反数，用HashMap）
 *  167. Two Sum II - Input array is sorted(排序数组中，和为target的两个数，用双指针)
 *  653. Two Sum IV - Input is a BST(二叉查找树中，和为target的两个数，用HashSet)
 ************************************************************************************************
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find
 * all unique triplets in the array which gives the sum of zero.
 *
 * Example:
 *  Input:  S = [-1, 0, 1, 2, -1, -4],
 *  Output: [
 *              [-1, 0, 1],
 *              [-1, -1, 2],
 *          ]
 *  Explanation:
 *      nums[0] + nums[1] = 2 + 7 = 9
 *
 * Note:
 *      The solution set must not contain duplicate triplets.
 ************************************************************************************************
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length-2; i++) {
            if(i == 0 || ( i > 0 && nums[i] != nums[i-1] ) ) { //遍历所有不同的数字，跳过相同的
                int lo = i+1;
                int hi = nums.length-1;
                while(lo < hi) {
                    if(nums[i]+nums[lo]+nums[hi] == 0) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[++lo]) {
                        }
                        while(lo < hi && nums[hi] == nums[--hi]) {
                        }
                    } else if(nums[i] + nums[lo] + nums[hi] < 0) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
