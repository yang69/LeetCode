package tree;

/**
 * Created by Yang on 2017/10/9.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) { //从左向右处理，逐层向下
        TreeLinkNode parent = root;
        TreeLinkNode current = null;
        while (parent != null && parent.left != null) { //还有下层需要处理
            current = parent;
            while (current != null && current.left != null) { //同一层中逐个向右处理
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            parent = parent.left; //转移到下一层的最左侧
        }
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
