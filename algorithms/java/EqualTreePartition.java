import java.util.HashSet;

/**
 * Created by Yang on 2017/8/20.
 ************************************************************************************************
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the
 * tree to two trees which have the equal sum of values after removing exactly one edge on the
 * original tree.
 *
 * Example 1:
 *  Input: 5
 *        / \
 *       10 10
 *         /  \
 *        2    3
 *  Output: True
 *  Explanation:
 *        5                10
 *       /                /  \
 *      10               2    3
 *      Sum: 15          Sum: 15
 *
 * Example 2:
 *  Input:   1
 *          / \
 *         2  10
 *           /  \
 *          2   20

 *  Output: False
 *  Explanation:
 *      You can't split the tree into two trees with equal sum after removing exactly one edge
 *      on the tree.
 *
 * Note:
 *      The range of tree node value is in the range of [-100000, 100000].
 *      1 <= n <= 10000
 ************************************************************************************************
 */
public class EqualTreePartition {
    /**
     * 题目等价于是否有一颗子树的和等于整棵树的和的一半。
     * 树的和可以通过递归的求左右子树的和，加上当前结点值的方式求得。
     * 在求整棵树的过程中，将各子树的和加入set中，最后只需检查set中是否存在整棵树的和的一半的值即可。
     * @param root
     * @return
     */
    public boolean checkEqualTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return false;
        }
        HashSet<Long> set = new HashSet<>();
        long total = getSum(root, set);
        if ((total & 1) == 0) {
            return set.contains(total/2);
        }
        return false;
    }

    private long getSum(TreeNode root, HashSet<Long> set) {
        if (root == null) {
            set.add(0L);
            return 0;
        }
        long sum = root.val + getSum(root.left, set) + getSum(root.right, set);
        set.add(sum);
        return sum;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
