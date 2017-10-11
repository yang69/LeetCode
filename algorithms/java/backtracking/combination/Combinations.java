package backtracking.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/10/5.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < 1 || k < 1) {
            return res;
        }
        addCombine(res, new ArrayList<Integer>(), n, k, 0);
        return res;
    }

    private void addCombine(List<List<Integer>> res, List<Integer> tempList, int n, int k, int pos) {
        if(tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = pos; i < n; i++) {
            tempList.add(i+1); //组合和排列的不同在于此处不会删去加进去的元素，而是从下一个位置处开始迭代，并且i从pos开始，全排列时i从0开始
            addCombine(res, tempList, n, k, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
