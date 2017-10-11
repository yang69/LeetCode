package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Yang on 2017/10/9.
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<>();
        List<Double> res = new LinkedList<>();

        if (root == null) return res;

        currentLevel.offer(root);
        while (!currentLevel.isEmpty()) {
            int levelNum = currentLevel.size();
            long sum = 0;
            double count = 0;
            for (int i = 0; i < levelNum; i++) {
                if (currentLevel.peek().left != null) {
                    currentLevel.add(currentLevel.peek().left);
                }
                if (currentLevel.peek().right != null) {
                    currentLevel.add(currentLevel.peek().right);
                }
                sum += currentLevel.poll().val;
                count++;
            }
            res.add(sum / count);
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
