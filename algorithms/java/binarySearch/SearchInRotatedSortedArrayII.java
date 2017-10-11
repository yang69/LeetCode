package binarySearch;

/**
 * Created by Yang on 2017/10/8.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[hi]) {
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[hi]){
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else { // nums[hi] == nums[mid] != target
                hi--;
            }
        }

        return nums[lo] == target;
    }

    public boolean searchLinear(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
