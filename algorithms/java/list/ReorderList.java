package list;

/**
 * Created by Yang on 2017/10/9.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) { //将链表分成前后两个部分
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        slow = reverseList(slow); //反转链表的后半部分
        while (slow != null) {
            ListNode nextNodeOfFirstHalf = head.next;
            ListNode nextNodeOfSecondHalf = slow.next;
            head.next = slow;
            slow.next = nextNodeOfFirstHalf;
            head = nextNodeOfFirstHalf;
            slow = nextNodeOfSecondHalf;
        }
        if (fast == null) { //偶数个结点
            head.next.next = null;
        } else { //奇数个结点
            head.next = null;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null; //前一个元素
        ListNode curr = head; //当前元素
        while (curr != null) { //将当前元素的next指针指向前一个元素
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
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
