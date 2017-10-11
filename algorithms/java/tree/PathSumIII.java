package tree;

import java.util.HashMap;

/**
 * Created by Yang on 2017/10/9.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return findPathSum(root, preSum, 0, sum);
    }

    private int findPathSum(TreeNode root, HashMap<Integer, Integer> preSum, int currentSum, int target) {
        if (root == null) {
            return 0;
        }
        currentSum += root.val;
        int res = preSum.getOrDefault(currentSum - target, 0);
        preSum.put(currentSum, preSum.getOrDefault(currentSum, 0) + 1);
        if (root.left != null) {
            res += findPathSum(root.left, preSum, currentSum, target);
        }
        if (root.right != null) {
            res += findPathSum(root.right, preSum, currentSum, target);
        }
        preSum.put(currentSum, preSum.getOrDefault(currentSum, 0) - 1);

        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
