package array;

import java.util.HashSet;

/**
 * Created by Yang on 2017/10/11.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> nSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) nSet.remove(nums[i - k - 1]);
            if (nSet.contains(nums[i])) return true;
            nSet.add(nums[i]);
        }
        return false;
    }
}
