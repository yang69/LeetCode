package list;

/**
 * Created by Yang on 2017/10/8.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode greaterHead = new ListNode(0);
        ListNode greater = greaterHead;
        ListNode lessHead = new ListNode(0);
        ListNode less = lessHead;
        while(head != null) {
            if(head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        less.next = greaterHead.next;
        greater.next = null;
        return lessHead.next;
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
