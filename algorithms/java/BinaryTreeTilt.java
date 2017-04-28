/**
 * Created by Yang on 2017/4/28.
 ************************************************************************************************
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as the absolute difference between the sum of all left
 * subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 *   Input:
 *         1
 *       /   \
 *      2     3
 *   Output:
 *      1
 *   Explanation:
 *      Tilt of node 2 : 0
 *      Tilt of node 3 : 0
 *      Tilt of node 1 : |2-3| = 1
 *      Tilt of binary tree : 0 + 0 + 1 = 1
 *
 * Note:
 *      The sum of node values in any subtree won't exceed the range of 32-bit integer.
 *      All the tilt values won't exceed the range of 32-bit integer.
 ************************************************************************************************
 */
public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        int[] totalTilt = new int[]{0};
        findTiltCore(root, totalTilt);

        return totalTilt[0];
    }

    private int findTiltCore(TreeNode root, int[] totalTilt) {
        if(root == null) {
            return 0;
        }
        int sumOfAllNodesInLeftSubtree = findTiltCore(root.left, totalTilt);
        int sumOfAllNodesInRightSubtree = findTiltCore(root.right, totalTilt);
        int tiltOfCurrentNode = sumOfAllNodesInLeftSubtree - sumOfAllNodesInRightSubtree;
        tiltOfCurrentNode = tiltOfCurrentNode < 0 ? -tiltOfCurrentNode : tiltOfCurrentNode;
        totalTilt[0] += tiltOfCurrentNode;

        return root.val + sumOfAllNodesInLeftSubtree + sumOfAllNodesInRightSubtree;
    }

    public static void main(String[] args) {
        BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(binaryTreeTilt.findTilt(root) + " <--> 9");
        System.out.println(binaryTreeTilt.findTilt(root.left) + " <--> 1");
        System.out.println(binaryTreeTilt.findTilt(root.left.left) + " <--> 0");
        System.out.println(binaryTreeTilt.findTilt(root.left.left.left) + " <--> 0");
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
