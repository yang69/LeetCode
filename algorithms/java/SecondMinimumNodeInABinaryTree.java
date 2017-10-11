import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Yang on 2017/9/3.
 */
public class SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int min = root.val;
        int second = min;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode curr = q.poll();
                if (curr.val != min) {
                    second = Math.min(second, curr.val);
                }
                if (curr.left != null) {
                    next.offer(curr.left);
                }
                if (curr.right != null) {
                    next.offer(curr.right);
                }
            }
            q = next;
        }
        return min == second ? -1 : second;
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
