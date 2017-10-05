package sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 454. 4Sum II
 * https://leetcode.com/problems/4sum-ii/
 * 找到和为target的数
 *  1. Two Sum(数组中，和为target的两个数，用HashMap)
 *  15. 3Sum（数组中，和为target的3个数，先排序，再用双指针）
 *  16. 3Sum Closest（数组中，和最接近于target的3个数，输出其和，先排序，再用双指针）
 *  18. 4Sum（数组中，和为target的4个数，先排序，再依次转化为3Sum和2Sum问题）
 *  167. Two Sum II - Input array is sorted(排序数组中，和为target的两个数，用双指针)
 *  653. Two Sum IV - Input is a BST(二叉查找树中，和为target的两个数，用HashSet)
 ************************************************************************************************
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are
 * such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All
 * integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most
 * 2^31 - 1.
 *
 * Example:
 *  Input:  A = [ 1, 2], B = [-2,-1], C = [-1, 2], D = [ 0, 2]
 *  Output: 2
 *  Explanation:
 *      The two tuples are:
 *      1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 *      2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 ************************************************************************************************
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                res += map.getOrDefault(-sum, 0);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FourSumII fourSumII = new FourSumII();

        System.out.println(fourSumII.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2})
                + " <---> 2");
    }
}
