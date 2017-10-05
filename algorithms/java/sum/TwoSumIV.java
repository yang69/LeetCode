package sum;

import java.util.HashSet;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 653. Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * 找到和为target的数
 *  1. Two Sum(数组中，和为target的两个数，用HashMap)
 *  15. 3Sum（数组中，和为target的3个数，先排序，再用双指针）
 *  16. 3Sum Closest（数组中，和最接近于target的3个数，输出其和，先排序，再用双指针）
 *  18. 4Sum（数组中，和为target的4个数，先排序，再依次转化为3Sum和2Sum问题）
 *  454. 4Sum II（4个数组中，分别取1个数，其中和为0的取法的个数，转换为2组2个数的和互为相反数，用HashMap）
 *  167. Two Sum II - Input array is sorted(和为target的两个数，用双指针)
 ************************************************************************************************
 * Given a Binary Search Tree and a target number, return true if there exist two elements in
 * the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *  Input:  5       Target = 9
 *         / \
 *        3   6
 *       / \   \
 *      2   4   7
 *  Output: true
 *
 * Example 2:
 *  Input:  5       Target = 28
 *         / \
 *        3   6
 *       / \   \
 *      2   4   7
 *  Output: false
 ************************************************************************************************
 */
public class TwoSumIV {
    // Two Sum III - Data structure design
    // https://www.programcreek.com/2014/03/two-sum-iii-data-structure-design-java/
    public boolean findTarget(TreeNode root, int k) {
        // use a hashset to find a pre appeared num in O(1)
        HashSet<Integer> set = new HashSet<>();
        return preOrder(root, k, set);
    }

    private boolean preOrder(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        int complement = k - root.val;
        if (set.contains(complement)) {
            return true;
        }
        set.add(root.val);
        return preOrder(root.left, k, set) || preOrder(root.right, k, set);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
