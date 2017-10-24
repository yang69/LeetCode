package tree;

import java.util.*;

/**
 * Created by Yang on 2017/10/24.
 */
public class FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = traverse(root, freq);
        List<Integer> modes = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modes.add(entry.getKey());
            }
        }
        int[] res = new int[modes.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = modes.get(i);
        }

        return res;
    }

    private int traverse(TreeNode root, Map<Integer, Integer> freq) {
        freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
        int maxFreq = freq.get(root.val);
        if (root.left != null) {
            maxFreq = Math.max(maxFreq, traverse(root.left, freq));
        }
        if (root.right != null) {
            maxFreq = Math.max(maxFreq, traverse(root.right, freq));
        }
        return maxFreq;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
