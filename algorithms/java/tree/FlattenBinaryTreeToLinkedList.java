package tree;

/**
 * Created by Yang on 2017/10/9.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        buildFlattenTree(root);
    }

    private TreeNode buildFlattenTree(TreeNode root) { //在这里把TreeNode当成“链表”(left不用，right当成链表的next)，递归创建这个“链表”就行
        if (root == null) {
            return null;
        }
        TreeNode rightPart = root.right;
        root.right = buildFlattenTree(root.left);
        root.left = null; //别忘了删除左子树
        TreeNode tail = root;
        while (tail.right != null) {
            tail = tail.right;
        }
        tail.right = buildFlattenTree(rightPart);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
