package number;

/**
 * Created by Yang on 2017/10/5.
 */
public class FindTheDuplicateNumber {
//    https://discuss.leetcode.com/topic/25913/my-easy-understood-solution-with-o-n-time-and-o-1-space-without-modifying-the-array-with-clear-explanation
    /**
     * 数组大小为n+1，数字的范围是1到n，所以可以将数字看成是指向数组特定位置的指针，
     * 那么整个数组可以看成一个列表。
     * 因为有数字是重复的，所以这个链表是有环的，问题转化成找到环的入口。
     * 参考 142. Linked List Cycle II
     * @param nums
     * @return
     */
//    public int findDuplicate(int[] nums) {
//    }

    /**
     * 抽屉原理，如果小于等于mid的数的数量大于mid个，那么1,2,...,mid之间的数肯定有重复的
     * @param nums
     * @return
     */
    public int findDuplicateUsingPigeonholePrinciple(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
