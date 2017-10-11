package backtracking.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang on 2017/10/5.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int target, int start) {
        if(target < 0) {
            return;
        } else if(target == 0) {
            res.add(new ArrayList<Integer>(tempList)); // 不能直接add(tempList)，因为添加进去的是引用，tempList在其他迭代回合中会修改
            return;
        } else {
            for(int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i-1]) { //跳过重复的元素
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(res, tempList, nums, target - nums[i], i + 1); //不允许重用
                tempList.remove(tempList.size()-1); //删除最后一个元素
            }
        }
    }
}
