package binarySearch;

/**
 * Created by Yang on 2017/10/5.
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left, right;

        int lo = 0, hi = nums.length - 1;
        while(lo < hi) { //二分查找左边界
            int mid = lo + (hi-lo)/2; //mid是lo、hi中间位置向左取整
            if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if(nums[lo] != target) {
            return new int[]{-1, -1};
        }
        left = lo;

        hi = nums.length-1;
        while(lo < hi) { //二分查找右边界
            int mid = lo + (hi-lo+1)/2; //mid是lo、hi中间位置向右取整
            if(nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        right = hi;
        return new int[]{left, right};
    }
}
