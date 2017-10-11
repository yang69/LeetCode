package tree;

/**
 * Created by Yang on 2017/10/9.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode prev = null; //当前层中的前一个结点
        TreeLinkNode head = null; //下一层中的首结点
        TreeLinkNode curr = root; //当前层中正在处理的结点
        while (curr != null) { //从上向下，逐层处理
            while (curr != null) { //从左向右，处理当前层的所有结点
                if (curr.left != null) {
                    if (prev != null) {
                        prev.next = curr.left;
                    } else {
                        head = curr.left;
                    }
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                    } else {
                        head = curr.right;
                    }
                    prev = curr.right;
                }
                //移动到当前层的右边一个结点
                curr = curr.next;
            }
            //移动到下一层的首结点
            curr = head;
            head = null;
            prev = null;
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
