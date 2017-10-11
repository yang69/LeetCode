package tree;

/**
 * Created by Yang on 2017/10/9.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        //if(root.left == null && root.right == null) return root.val == sum;
        //if(root.left == null) return hasPathSum(right, sum - root.val);
        //if(root.right == null) return hasPathSum(left, sum - root.val);
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
