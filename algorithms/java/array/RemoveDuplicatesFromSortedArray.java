package array;

/**
 * Created by Yang on 2017/10/4.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else {
            int i = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i +1;
        }
    }
}
