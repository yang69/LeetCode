package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        findNums(root, list, 0);
        int res = 0;
        for (int num : list) {
            res += num;
        }
        return res;
    }

    private void findNums(TreeNode root, List<Integer> list, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(10 * num + root.val);
        }
        findNums(root.left, list, 10 * num + root.val);
        findNums(root.right, list, 10 * num + root.val);
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
