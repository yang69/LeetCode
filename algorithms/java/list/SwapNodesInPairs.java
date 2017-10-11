package list;

/**
 * Created by Yang on 2017/10/4.
 */
public class SwapNodesInPairs {
    /**
     * 用递归实现
     * @param head
     * @return
     */
    public ListNode swapPairsRecursion(ListNode head) {
        if( (head == null) || (head.next == null) ) {
            return head;
        }
        ListNode res = head.next;
        head.next = swapPairsRecursion(head.next.next);
        res.next = head;
        return res;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
        public String toString() {
            if(next == null) {
                return val + "";
            }
            return val + ", " + this.next;
        }
    }
}
