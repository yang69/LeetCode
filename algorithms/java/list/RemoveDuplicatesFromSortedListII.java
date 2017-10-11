package list;

/**
 * Created by Yang on 2017/10/8.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(-1); //在head节点之前附加一个虚节点
        fake.next = head;
        head = fake;
        ListNode tail = head; //tail指向最后一个不重复的元素
        boolean dup = false;
        for(ListNode temp = head.next; temp != null && temp.next != null; temp = temp.next) {
            if(dup) {
                if(temp.val == temp.next.val) {
                    continue;
                } else {
                    dup = false;
                    tail.next = temp.next;
                }
            } else {
                if(temp.val == temp.next.val) {
                    dup = true;
                } else {
                    tail = temp;
                }
            }
        }
        if(dup) {
            tail.next = null;
        }
        return head.next;
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
