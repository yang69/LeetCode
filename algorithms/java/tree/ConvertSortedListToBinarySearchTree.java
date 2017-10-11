package tree;

/**
 * Created by Yang on 2017/10/9.
 */
public class ConvertSortedListToBinarySearchTree {

    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return sortedListToBST(0, len - 1);
    }

    private TreeNode sortedListToBST(int low, int high) {
        if (low > high || head == null) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode leftTree = sortedListToBST(low, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = leftTree;
        root.right = sortedListToBST(mid + 1, high);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public String toString() {
            if (next == null) {
                return val + "";
            }
            return val + ", " + this.next;
        }
    }
}
