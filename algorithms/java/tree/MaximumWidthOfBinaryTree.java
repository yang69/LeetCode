import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang on 2017/8/20.
 ************************************************************************************************
 * Given a binary tree, write a function to get the maximum width of the given tree. The width
 * of a tree is the maximum width among all levels. The binary tree has the same structure as a
 * full binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes (the leftmost and right
 * most non-null nodes in the level, where the null nodes between the end-nodes are also counted
 * into the length calculation.
 *
 * Example 1:
 *  Input:  1
 *         / \
 *        3   2
 *       / \   \
 *      5   3   9
 *  Output: 4
 *  Explanation:
 *      The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Example 2:
 *  Input:  1
 *         /
 *        3
 *       / \
 *      5   3
 *  Output: 2
 *  Explanation:
 *      The maximum width existing in the third level with the length 2 (5,3).
 *
 * Example 3:
 *  Input:  1
 *         / \
 *        3   2
 *       /
 *      5
 *  Output: 2
 *  Explanation:
 *      The maximum width existing in the third level with the length 2 (3,2).
 *
 * Example 4:
 *  Input:    1
 *           / \
 *          3   2
 *         /     \
 *        5       9
 *       /         \
 *      6           7
 *  Output: 8
 *  Explanation:
 *      The maximum width existing in the fourth level with the length 8
 *      (6,null,null,null,null,null,null,7).
 *
 * Note:
 *      Answer will in the range of 32-bit signed integer.
 ************************************************************************************************
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 层次遍历，看最左侧结点和最右侧结点的编号之差
        int width = 1;
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<Long> currentNO = new LinkedList<>();
        currentLevel.offer(root);
        currentNO.offer(1L);
        while(!currentLevel.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            Queue<Long> nextNO = new LinkedList<>();
            long first = currentNO.peek();
            long last = first;
            while (!currentLevel.isEmpty()) {
                TreeNode node = currentLevel.poll();
                last = currentNO.poll();
                if (node.left != null) {
                    nextLevel.offer(node.left);
                    nextNO.offer(last * 2);
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                    nextNO.offer(last * 2 + 1);
                }
            }
            width = Math.max(width, (int)(last - first + 1));
            currentLevel = nextLevel;
            currentNO = nextNO;
        }
        return width;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
