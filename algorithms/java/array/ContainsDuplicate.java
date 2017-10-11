package array;

import java.util.HashSet;

/**
 * Created by Yang on 2017/10/11.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numset.contains(nums[i])) {
                return true;
            }
            numset.add(nums[i]);
        }
        return false;
    }
}
