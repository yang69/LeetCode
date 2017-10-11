package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang on 2017/10/8.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        addSubsets(res, list, nums, 0);
        return res;
    }

    private void addSubsets(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
        res.add(new ArrayList<Integer>(list)); //添加到List里的是引用，而此处的list是个经常变动的临时变量，所以需要new
        for(int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            addSubsets(res, list, nums, i + 1); //i+1，而不是pos+1
            list.remove(list.size()-1);
        }
    }
}
