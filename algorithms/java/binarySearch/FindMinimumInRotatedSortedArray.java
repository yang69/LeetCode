package binarySearch;

/**
 * Created by Yang on 2017/10/9.
 */
public class FindMinimumInRotatedSortedArray {
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
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
