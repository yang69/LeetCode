package list;

/**
 * Created by Yang on 2017/10/7.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        ListNode temp = head;
        ListNode last = head;
        int listSize = 0;
        while(temp != null) {
            listSize++;
            last = temp;
            temp = temp.next;
        }
        k %= listSize;
        if(k == 0) {
            return head;
        }
        int count = listSize - k;
        last.next = head;
        while(count-- > 1) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
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
