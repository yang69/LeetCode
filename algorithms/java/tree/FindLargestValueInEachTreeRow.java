package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/24.
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largest = new LinkedList<>();
        if (root == null) {
            return largest;
        }
        traverse(root, 0, largest);
        return largest;
    }

    private void traverse(TreeNode node, int depth, List<Integer> largest) {
        if (largest.size() > depth) {
            if (node.val > largest.get(depth)) {
                largest.set(depth, node.val);
            }
        } else {
            largest.add(node.val);
        }
        if (node.left != null) {
            traverse(node.left, depth + 1, largest);
        }
        if (node.right != null) {
            traverse(node.right, depth + 1, largest);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
