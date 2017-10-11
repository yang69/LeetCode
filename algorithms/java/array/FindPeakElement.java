package array;

/**
 * Created by Yang on 2017/10/9.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean greaterThanLeft = i == 0 || nums[i] > nums[i - 1];
            boolean greaterThanRight = i == nums.length - 1 || nums[i] > nums[i + 1];
            if (greaterThanLeft && greaterThanRight) {
                return i;
            }
        }
        return -1;
    }
}
