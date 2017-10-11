package backtracking.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang on 2017/10/5.
 * https://discuss.leetcode.com/topic/46161/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                tempList.add(nums[i]);
                backtrack(res, tempList, nums, target - nums[i], i); //因为允许重用，所以可以从i开始
                tempList.remove(tempList.size()-1); //删除最后一个元素
            }
        }
    }
}
