package sum;

/**
 * Created by Yang on 2017/10/23.
 */
public class RangeSumQueryImmutable {
}

class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j <= i; j++) {
                sums[i] += nums[j];
            }
        }
    }

    public int sumRange(int i, int j) {
        return i > 0 ? sums[j] - sums[i-1] : sums[j];
    }
}
