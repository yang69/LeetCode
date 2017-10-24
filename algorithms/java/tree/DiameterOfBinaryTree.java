package tree;

/**
 * Created by Yang on 2017/10/24.
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        getDepth(root, res);
        return res[0];
    }

    private int getDepth(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left, res);
        int rightDepth = getDepth(root.right, res);
        res[0] = Math.max(res[0], leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
