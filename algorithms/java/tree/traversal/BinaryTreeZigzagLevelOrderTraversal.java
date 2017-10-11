package tree.traversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) { //尚未建立level这一层的List<Integer>
            res.add(new LinkedList<>());
        }
        List<Integer> currentLevel = res.get(level); //拿出level这一层的列表
        if (level % 2 == 0) { //Zigzag
            currentLevel.add(root.val); //当前结点的值附加到列表尾部
        } else {
            currentLevel.add(0, root.val); //当前结点的值附加到列表头部
        }
        travel(root.left, res, level + 1);
        travel(root.right, res, level + 1);
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
