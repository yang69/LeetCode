package tree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Yang on 2017/10/9.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        if (root == null) return res;

        currentLevel.offer(root);
        while (!currentLevel.isEmpty()) {
            int levelNum = currentLevel.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (currentLevel.peek().left != null) {
                    currentLevel.add(currentLevel.peek().left);
                }
                if (currentLevel.peek().right != null) {
                    currentLevel.add(currentLevel.peek().right);
                }
                subList.add(currentLevel.poll().val);
            }
            res.add(subList);
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
