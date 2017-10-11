package tree.binarySearchTree;

/**
 * Created by Yang on 2017/10/8.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.val == Integer.MIN_VALUE && root.left != null) return false;
        if (root.val == Integer.MAX_VALUE && root.right != null) return false;
        return isValidBST(root.left, Integer.MIN_VALUE, root.val - 1) && isValidBST(root.right, root.val + 1, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val == Integer.MIN_VALUE && root.left != null) return false;
        if (root.val == Integer.MAX_VALUE && root.right != null) return false;
        if (root.val < min || root.val > max) return false;
        return isValidBST(root.left, min, root.val - 1) && isValidBST(root.right, root.val + 1, max);
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
