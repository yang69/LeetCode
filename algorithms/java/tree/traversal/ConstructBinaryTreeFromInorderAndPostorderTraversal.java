package tree.traversal;

/**
 * Created by Yang on 2017/10/9.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTree(int[] inorder, int from1, int to1, int[] postorder, int from2, int to2) {
        if (from2 >= to2) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[to2 - 1]); //后序遍历的最后一个结点就是根节点
        int i;
        for (i = from1; i < to1; i++) { //在中序遍历中找到根结点（所有结点的值都不相同）
            if (inorder[i] == postorder[to2 - 1]) {
                break;
            }
        }
        int lengthOfLeftSubtree = i - from1;
        root.left = buildTree(inorder, from1, i, postorder, from2, from2 + lengthOfLeftSubtree);
        root.right = buildTree(inorder, i + 1, to1, postorder, from2 + lengthOfLeftSubtree, to2 - 1);
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
