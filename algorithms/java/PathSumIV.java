/**
 * Created by Yang on 2017/9/3.
 * https://discuss.leetcode.com/category/1485/path-sum-iv
 ************************************************************************************************
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of
 * three-digits integers.
 * For each integer in this list:
 *   The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 *   The tens digit represents the position P of this node in the level it belongs to,
 *     1 <= P <= 8. The position is the same as that in a full binary tree.
 *   The units digit represents the value V of this node, 0 <= V <= 9.
 * Given a list of ascending three-digits integers representing a binary with the depth smaller
 * than 5. You need to return the sum of all paths from the root towards the leaves.
 *
 * Example 1:
 *  Input:  [113, 215, 221]
 *  Output: 12
 *  Explanation:
 *      The tree that the list represents is:
 *           3
 *          / \
 *         5   1
 *      The path sum is (3 + 5) + (3 + 1) = 12.
 *
 * Example 2:
 *  Input:  [113, 221]
 *  Output: 4
 *  Explanation:
 *      The tree that the list represents is:
 *          3
 *           \
 *            1
 *      The path sum is (3 + 1) = 4.
 ************************************************************************************************
 */
public class PathSumIV {
    public int pathSum(int[] nums) {
        int[] nodes = new int[15];
        boolean[] exists = new boolean[31];
        for (int n : nums) {
            int level = n / 100;
            int position = (n % 100) / 10;
            int val = (n % 10);
            int index = (1 << (level - 1)) + position - 2;
            nodes[index] = val;
            exists[index] = true;
        }
        return getPathSum(nodes, exists, 15, 0, 0);
    }

    private int getPathSum(int[] nodes, boolean[] exists, int size, int index, int currentSum) {
        int sum = 0;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (!exists[left] && !exists[right]) {
            return currentSum + nodes[index];
        }
        if (exists[left]) {
            sum += getPathSum(nodes, exists, size, left, currentSum + nodes[index]);
        }
        if (exists[right]) {
            sum += getPathSum(nodes, exists, size, right, currentSum + nodes[index]);
        }
        return sum;
    }
}
