package tree.traversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/8.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            postorderTraversal(root.left, res);
        }
        if (root.right != null) {
            postorderTraversal(root.right, res);
        }
        res.add(root.val);
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
