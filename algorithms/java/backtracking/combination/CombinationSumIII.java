package backtracking.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/5.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        int min = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += (9 - i);
            min += (i + 1);
        }
        if (n > max || n < min) {
            return res;
        }
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            nums.add(i);
        }
        backtrack(res, new LinkedList<>(), nums, 0, n, k);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, List<Integer> nums, int start, int target, int allowSize) {
        if (target < 0 || allowSize < 0) {
            return;
        } else if (0 == target && allowSize == 0) {
            res.add(new ArrayList<>(tempList));
        } else if (allowSize > 0){
            for (int i = start; i < nums.size(); i++) {
                int num = nums.get(i);
//                nums.remove(i);
                tempList.add(num);
                backtrack(res, tempList, nums, num, target - num, allowSize - 1);
//                nums.add(i, num);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();

        System.out.println(combinationSumIII.combinationSum3(3, 7));
        System.out.println(combinationSumIII.combinationSum3(3, 9));
    }
}
