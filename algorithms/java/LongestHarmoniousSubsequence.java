import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Yang on 2017/5/31.
 ************************************************************************************************
 * We define a harmonious array is an array where the difference between its maximum value and
 * its minimum value is exactly 1.
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence
 * among all its possible subsequences.
 *
 * Example 1:
 *   Input:
 *      [1,3,2,2,5,2,3,7]
 *   Output:
 *      5
 * Explanation:
 *      The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Note:
 *      The length of the input array will not exceed 20,000.
 ************************************************************************************************
 */
public class LongestHarmoniousSubsequence {
    /**
     * 排序
     * @param nums
     * @return
     */
    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i])
                j++;
            if (j < nums.length && nums[j] == nums[i] + 1) {
                int k = j + 1;
                while (k < nums.length && nums[k] == nums[j])
                    k++;
                if (k - i > max)
                    max = k - i;
            }
            i = j;
        }

        return max;
    }

    /**
     * 使用HashMap
     * @param nums
     * @return
     */
    public int findLHS2(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int length = map.get(key) + map.get(key+1);
                res = length > res ? length : res;
            }
        }

        return res;
    }

    /**
     * 使用HashMap，一次遍历
     * @param nums
     * @return
     */
    public int findLHS3(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
            if (map.containsKey(num+1))
                res = Math.max(res, map.get(num) + map.get(num+1));
            if (map.containsKey(num-1))
                res = Math.max(res, map.get(num) + map.get(num-1));
        }

        return res;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();

        System.out.println(longestHarmoniousSubsequence.findLHS1(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(longestHarmoniousSubsequence.findLHS2(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(longestHarmoniousSubsequence.findLHS3(new int[]{1,3,2,2,5,2,3,7}));
    }
}
