package array;

/**
 * Created by Yang on 2017/10/8.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int len = 0; // 有效数列的长度
        for (int n : nums) {
            // 因为数组是有序的，只要当前值大于当前有效数列的倒数第二个数，说明这个数没有在有效数列中重复过2次以上
            if (len < 2 || n > nums[len - 2]) {
                nums[len++] = n;
            }
        }

        return len;
    }
}
