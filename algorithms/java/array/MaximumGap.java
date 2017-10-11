package array;

import java.util.Arrays;

/**
 * Created by Yang on 2017/10/9.
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        int maxGap = 0;
        if (nums == null || nums.length < 2) {
            return maxGap;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i-1]);
        }
        return maxGap;
    }
}
