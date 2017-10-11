package number;

import java.util.Arrays;

/**
 * Created by Yang on 2017/10/6.
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        // min1是最小值，min2是次小值
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // max1是最大值，max2是次大值，max3是第三大的值
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                max3 = n;
            }
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public int maximumProductUsingSorting(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3], nums[0] * nums[1] * nums[nums.length-1]);
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers maximumProductOfThreeNumbers = new MaximumProductOfThreeNumbers();

        System.out.println(maximumProductOfThreeNumbers.maximumProduct(new int[]{1,2,3})
                + " <---> " + maximumProductOfThreeNumbers.maximumProductUsingSorting(new int[]{1,2,3}));
        System.out.println(maximumProductOfThreeNumbers.maximumProduct(new int[]{1,2,3,4})
                + " <---> " + maximumProductOfThreeNumbers.maximumProductUsingSorting(new int[]{1,2,3,4}));
    }
}
