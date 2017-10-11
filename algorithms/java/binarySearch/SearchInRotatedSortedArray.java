package binarySearch;

/**
 * Created by Yang on 2017/10/5.
 */
public class SearchInRotatedSortedArray {
    /**
     * nums中没有重复的值，考虑用二分查找
     * 先找到nums中最小的值，得出偏移量，再用二分查找找到target
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || 0 == nums.length) {
            return -1;
        }
        // 首先找到nums中的最小值，确定偏移量
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int rotate = lo;
        lo = 0;
        hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo)/2;
            int realMid = (mid + rotate) % n; //加上偏移量，得到实际的位置
            if (nums[realMid] == target) {
                return realMid;
            } else if (nums[realMid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int index = (lo + rotate) % n;
        return nums[index] == target ? index : -1;
    }

    public int searchBruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();

        System.out.println(sirsa.search(new int[]{4,5,6,7,0,1,2}, 1)
                + " <---> " + sirsa.searchBruteForce(new int[]{4,5,6,7,0,1,2}, 1));
        System.out.println(sirsa.search(new int[]{4,5,6,7,0,1,2}, 3)
                + " <---> " + sirsa.searchBruteForce(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
