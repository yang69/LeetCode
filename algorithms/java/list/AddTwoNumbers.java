package list;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 ************************************************************************************************
 * You are given two non-empty linked lists representing two non-negative integers. The digits
 * are stored in reverse order and each of their nodes contain a single digit. Add the two
 * numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *  Input:  (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 ************************************************************************************************
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while(null != l1 || null != l2 || 0 != carry) {
            int num1 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            int num2 = 0;
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return dummyHead.next;
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

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers.addTwoNumbers(l1, l2) + " <---> 7, 0, 8");
        System.out.println(addTwoNumbers.addTwoNumbers(new ListNode(4), new ListNode(6)) + " <---> 0, 1");
    }
}
