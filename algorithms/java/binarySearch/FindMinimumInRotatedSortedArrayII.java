package binarySearch;

/**
 * Created by Yang on 2017/10/9.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            // 如果左侧值小于右侧值，最小值就是左侧值
            if (nums[lo] < nums[hi]) {
                return nums[lo];
            }
            int mid = lo + (hi - lo) / 2;
            // 中间值比右侧值大的话，最小值在右侧，否则在左侧
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else { // 左侧值==右侧值==中间值，无法判断，只能线性查找
                return linearFind(nums);
            }
        }
        return nums[lo];
    }

    private int linearFind(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}
