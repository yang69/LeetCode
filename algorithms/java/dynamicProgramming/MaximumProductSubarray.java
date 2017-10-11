package dynamicProgramming;

/**
 * Created by Yang on 2017/10/6.
 * 238. Product of Array Except Self
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        // imax 表示以nums[i]结尾的子数组的最大乘积
        // imin 表示以nums[i]结尾的子数组的最小乘积
        for (int i = 1, imax = nums[0], imin = nums[0]; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);

            res = Math.max(res, imax);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();

        System.out.println(maximumProductSubarray.maxProduct(new int[]{2,3,-2,4}) + " <---> 6");
    }
}
