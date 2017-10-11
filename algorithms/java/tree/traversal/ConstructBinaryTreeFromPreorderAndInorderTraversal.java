package tree.traversal;

/**
 * Created by Yang on 2017/10/9.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int from1, int to1, int[] inorder, int from2, int to2) {
        if (to1 - from1 < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[from1]);
        int i;
        for (i = from2; i < to2; i++) {
            if (inorder[i] == preorder[from1]) {
                break;
            }
        }
        int lengthOfLeftSubtree = i - from2;
        root.left = buildTree(preorder, from1 + 1, from1 + lengthOfLeftSubtree + 1, inorder, from2, i);
        root.right = buildTree(preorder, from1 + lengthOfLeftSubtree + 1, to1, inorder, i + 1, to2);
        return root;
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
