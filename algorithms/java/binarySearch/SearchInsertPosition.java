package binarySearch;

/**
 * Created by Yang on 2017/10/5.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo] < target ? lo + 1 : lo;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,7,9}, 6));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,7,9}, 0));
        System.out.println(searchInsertPosition.searchInsert(new int[]{1,3,5,7,9}, 10));
    }
}
