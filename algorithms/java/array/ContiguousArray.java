package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang on 2017/10/16.
 */
public class ContiguousArray {
    // https://leetcode.com/articles/contiguous-array/
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0;
        int count = 0; // count在遇到1时自增，在遇到0时自减，当count=0时，表示1和0的数量相同
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
