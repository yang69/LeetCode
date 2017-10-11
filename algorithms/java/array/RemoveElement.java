package array;

/**
 * Created by Yang on 2017/10/4.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        } else {
            int i = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }

    public int removeElementDisorder(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
