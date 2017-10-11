package array;

import java.util.TreeSet;

/**
 * Created by Yang on 2017/10/11.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        // 需要查找的是范围，作加减法的过程中可能会溢出
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果值不存在，ceiling和floor会返回null，所以要用Long，而不是long
            Long ceiling = set.ceiling((long) nums[i]);
            Long floor = set.floor((long) nums[i]);
            if (ceiling != null && ceiling - nums[i] <= t || floor != null && nums[i] - floor <= t) {
                return true;
            }
            set.add((long) nums[i]);
            // 窗口大小为k，除去当前遍历的，set中应该留k-1个值
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
