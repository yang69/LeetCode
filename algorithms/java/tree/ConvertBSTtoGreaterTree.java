package tree;

/**
 * Created by Yang on 2017/10/24.
 */
public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        reverseInorderTraverse(root, new int[1]);
        return root;
    }

    private void reverseInorderTraverse(TreeNode root, int[] sumOfGreaterValue) {
        if (root == null) {
            return;
        }
        reverseInorderTraverse(root.right, sumOfGreaterValue);
        root.val += sumOfGreaterValue[0];
        sumOfGreaterValue[0] = root.val;
        reverseInorderTraverse(root.left, sumOfGreaterValue);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
