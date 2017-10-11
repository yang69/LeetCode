package list;

/**
 * Created by Yang on 2017/10/8.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n == m) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next; //m号节点，逆序子列的队头
        ListNode needRerve = prev.next.next; //下一个需要逆序的元素
        for (int i = 0; i < n - m; i++) { //不断将下一个需要逆序的元素插入到第m个位置
            start.next = needRerve.next;
            needRerve.next = prev.next;
            prev.next = needRerve;
            needRerve = start.next;
        }
        return fakeHead.next;
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
