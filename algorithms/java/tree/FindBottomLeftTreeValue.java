package tree;

/**
 * Created by Yang on 2017/10/24.
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[2]);
    }

    // res[0]表示当前的可能的最左值，res[1]表示res[0]的深度
    private int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (depth > res[1]) { // 找到更深一层的最左值
            res[0] = root.val;
            res[1] = depth;
        }
        // 先遍历左子树，后便利右子树，这样，当相同深度的最左值更新过res[]后，右边的值就会被忽略
        if (root.left != null) {
            findBottomLeftValue(root.left, depth+1, res);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth+1, res);
        }

        return res[0];
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
