package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Yang on 2017/10/24.
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        int[] maxCount = new int[1];
        getSum(root, sumToCount, maxCount);
        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : sumToCount.entrySet()) {
            if (entry.getValue() == maxCount[0]) {
                res.add(entry.getKey());
            }
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = res.get(i);
        }

        return array;
    }

    private int getSum(TreeNode root, Map<Integer, Integer> sumToCount, int[] maxCount) {
        if (root == null) {
            return 0;
        }
        int sumOfLeftSubtree = getSum(root.left, sumToCount, maxCount);
        int sumOfRightSubtree = getSum(root.right, sumToCount, maxCount);
        int sum = root.val + sumOfLeftSubtree + sumOfRightSubtree;
        sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        maxCount[0] = Math.max(maxCount[0], sumToCount.get(sum));
        return sum;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
