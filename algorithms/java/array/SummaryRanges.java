package array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/11.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        int previous = nums[0];
        int current = nums[0];
        sb.append(current);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == current + 1) {
                current = nums[i];
                if (i == nums.length - 1) {
                    sb.append("->").append(current);
                }
            } else {
                if (previous == current) {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    res.add(sb.append("->").append(current).toString());
                    sb = new StringBuilder();
                }
                sb.append(nums[i]);
                previous = nums[i];
                current = nums[i];
            }
        }
        if (sb.length() > 0) {
            res.add(sb.toString());
        }

        return res;
    }
}
