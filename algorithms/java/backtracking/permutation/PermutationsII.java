package backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang on 2017/10/5.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used) {
        if(tempList.size() == nums.length) {
            res.add(new ArrayList<Integer>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(used[i]) {
                    continue;
                }
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) { //相同数字禁止后向尝试
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(res, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1); //删除最后一个元素
            }
        }
    }
}
