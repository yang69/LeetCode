package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> currentLevel = new LinkedList<>();
        if (root != null) {
            currentLevel.offerLast(root);
        }
        while (currentLevel.size() > 0) {
            res.add(currentLevel.peekLast().val);
            Deque<TreeNode> nextLevel = new LinkedList<>();
            while (currentLevel.size() > 0) {
                TreeNode node = currentLevel.pollFirst();
                if (node.left != null) {
                    nextLevel.offerLast(node.left);
                }
                if (node.right != null) {
                    nextLevel.offerLast(node.right);
                }
            }
            currentLevel = nextLevel;
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
