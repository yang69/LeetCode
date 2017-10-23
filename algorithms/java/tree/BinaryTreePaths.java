package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/19.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root != null) {
            searchBT(root, "", res);
        }

        return res;
    }

    private void searchBT(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", res);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", res);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
