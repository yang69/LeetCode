package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Yang on 2017/10/9.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new LinkedList<List<Integer>>();
        Stack<Integer> path = new Stack<>();
        findPath(root, sum, path, paths);
        return paths;
    }

    private void findPath(TreeNode root, int sum, Stack<Integer> path, List<List<Integer>> paths) {
        if (root == null) return;//节点不存在，当前已无路径可供搜索
        path.push(root.val);
        if (root.left == null && root.right == null && root.val == sum) {//已到叶子节点
            paths.add(new ArrayList(path));
        } else {
            findPath(root.left, sum - root.val, path, paths);
            findPath(root.right, sum - root.val, path, paths);
        }
        path.pop();//将添加的root.val删去，回退一步，以进行另一边子树的搜索
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
