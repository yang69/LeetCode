package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/10/5.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        backtrack(res, new ArrayList<Integer>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            res.add(new ArrayList<Integer>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(res, tempList, nums);
                tempList.remove(tempList.size() - 1); //删除最后一个元素
            }
        }
    }
}
