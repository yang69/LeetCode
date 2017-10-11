package tree;

/**
 * Created by Yang on 2017/10/9.
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int from, int to) {
        if (from > to) {
            return null;
        }
        int maxIndex = maxIndex(nums, from, to);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(nums, from, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, to);

        return root;
    }

    private int maxIndex(int[] nums, int from , int to) {
        int maxIndex = from;
        for (int i = from + 1; i <= to; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
