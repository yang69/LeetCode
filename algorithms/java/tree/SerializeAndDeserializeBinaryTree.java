package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Yang on 2017/10/11.
 */
public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node == null) {
                    res.add(null);
                } else {
                    res.add(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String s = data.substring(1, data.length() - 1);
        String[] ss = s.split(",\\s+");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        q.offer(root);
        for (int i = 1; i < ss.length; i++) {
            TreeNode parent = q.poll();
            if (!ss[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(ss[i]));
                q.offer(parent.left);
            }
            if (!ss[++i].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(ss[i]));
                q.offer(parent.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree sadbt = new SerializeAndDeserializeBinaryTree();

        System.out.println(sadbt.serialize(new TreeNode(1)));
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
