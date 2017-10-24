package tree;

/**
 * Created by Yang on 2017/10/24.
 */
public class KthSmallestElementInaBST {
    public int kthSmallest(TreeNode root, int k) {
        int numLeftSubtree = count(root.left);
        if (k <= numLeftSubtree) {
            return kthSmallest(root.left, k);
        } else if (k == numLeftSubtree + 1) {
            return root.val;
        } else {
            return kthSmallest(root.right, k - numLeftSubtree - 1);
        }
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
