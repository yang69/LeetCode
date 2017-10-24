package tree;

/**
 * Created by Yang on 2017/10/24.
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        // 递归求解，用d=0表示原来的结点应该放在新结点的右子树
        if (d == 1) {
            TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }
        if (d == 0) {
            TreeNode res = new TreeNode(v);
            res.right = root;
            return res;
        }
        if (root != null) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
