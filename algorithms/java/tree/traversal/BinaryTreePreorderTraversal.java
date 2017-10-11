package tree.traversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/8.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode root, List<Integer> res) {
        res.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left, res);
        }
        if (root.right != null) {
            preorderTraversal(root.right, res);
        }
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
