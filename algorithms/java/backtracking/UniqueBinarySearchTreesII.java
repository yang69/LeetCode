package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int from, int to) {
        List<TreeNode> res = new LinkedList<>();
        if (from > to) {
            res.add(null);
            return res;
        }
        if (from == to) {
            res.add(new TreeNode(from));
            return res;
        }
        for (int i = from; i <= to; i++) {
            List<TreeNode> lefts = generateTrees(from, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, to);
            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
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
