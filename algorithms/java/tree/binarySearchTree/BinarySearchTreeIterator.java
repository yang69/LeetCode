package tree.binarySearchTree;

import java.util.Stack;

/**
 * Created by Yang on 2017/10/8.
 */
public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

//    public BSTIterator(TreeNode root) {
//        pushAll(root);
//    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
