package sort;

/**
 * Created by Yang on 2017/10/9.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        //归并排序|merge sort

        if (head == null || head.next == null) { //小于2个结点时，无需排序
            return head;
        }

        //1. 将链表分为两半
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        //2. 将前后两部分链表分别排序
        slow = sortList(head);
        fast = sortList(fast);

        //3. 归并
        return mergeTwoSortedList(slow, fast);
    }

    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); //fake head node
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return dummy.next;
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
