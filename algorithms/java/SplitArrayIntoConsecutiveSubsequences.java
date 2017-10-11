import java.util.HashMap;

/**
 * Created by Yang on 2017/8/19.
 ************************************************************************************************
 * You are given an integer array sorted in ascending order (may contain duplicates), you need
 * to split them into several subsequences, where each subsequences consist of at least 3
 * consecutive integers. Return whether you can make such a split.
 *
 * Example 1:
 *  Input: [1,2,3,3,4,5]
 *  Output: True
 *  Explanation:
 *      You can split them into two consecutive subsequences :
 *      1, 2, 3
 *      3, 4, 5
 *
 * Example 2:
 *  Input: [1,2,3,3,4,4,5,5]
 *  Output: True
 *  Explanation:
 *      You can split them into two consecutive subsequences :
 *      1, 2, 3, 4, 5
 *      3, 4, 5
 *
 * Example 3:
 *  Input: [1,2,3,4,4,5]
 *  Output: False
 *
 * Note:
 *      The length of the input is in range of [1, 10000]
 ************************************************************************************************
 */
public class SplitArrayIntoConsecutiveSubsequences {
//    public boolean isPossible(int[] nums) {
//        HashMap<Integer, Integer> freq = new HashMap<>();
//        int min = Integer.MAX_VALUE;
//        int count = 0;
//        // 统计每个数字的出现频率
//        for (int num : nums) {
//            freq.put(num, freq.getOrDefault(num, 0) + 1);
//            min = Math.min(min, num);
//            count++;
//        }
//
//        // 从最小的数开始，将之添加到最短的
//    }
}
