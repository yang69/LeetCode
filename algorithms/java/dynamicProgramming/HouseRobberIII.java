package dynamicProgramming;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by Yang on 2017/10/6.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = robCore(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * @param root
     * @return res[0]是抢root，res[1]对应于不抢root
     */
    private int[] robCore(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2];
        int[] left = robCore(root.left);
        int[] right = robCore(root.right);
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public static void main(String[] args) {
        HouseRobberIII houseRobberIII = new HouseRobberIII();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(houseRobberIII.rob(root) + " <---> 7");

        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(houseRobberIII.rob(root) + " <---> 9");
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
