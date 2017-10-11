package backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/10/5.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int total = 1;
        for(int i = 1; i <= n; i++) {
            nums.add(i);
            total *= i;
        }
        if(k > total) {
            return "";
        }
        // Construct the k-th permutation with a list of n numbers
        // Idea: group all permutations according to their first number (so n groups, each of
        // (n-1)! numbers), find the group where the k-th permutation belongs, remove the common
        // first number from the list and append it to the resulting string, and iteratively
        // construct the (((k-1)%(n-1)!)+1)-th permutation with the remaining n-1 numbers
        StringBuilder sb = new StringBuilder();
        int group = total;
        while(n > 0) {
            group /= n;
            int idx = (k - 1) / group;
            //k = (k - 1) % group + 1;
            k -= group * idx;
            sb.append(nums.get(idx));
            nums.remove(idx);
            n--;
        }
        return sb.toString();
    }
}
