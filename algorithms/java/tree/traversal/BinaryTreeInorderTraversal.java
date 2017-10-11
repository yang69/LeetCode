package tree.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang on 2017/10/8.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        //中序遍历
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        } else {
            inorderAdd(res, root.left);
            res.add(root.val);
            inorderAdd(res, root.right);
        }
        return res;
    }

    private void inorderAdd(List<Integer> res, TreeNode root) {
        if (root == null) return;
        inorderAdd(res, root.left);
        res.add(root.val);
        inorderAdd(res, root.right);
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
