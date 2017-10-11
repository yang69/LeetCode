package sort;

/**
 * Created by Yang on 2017/10/9.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) { //结点个数小于2，无需排序
            return head;
        }
        ListNode sorted = head; //有序部分，初始化时sorted只有head的首结点
        head = head.next; //无序部分，初始化时除了head的首结点都是无序部分
        sorted.next = null; //这一行一定要在head = head.next的下面，否则head后面的值就被删了，这一行必须有，否则sorted链表没有结尾
        while (head != null) {
            //1. 从未排序部分取出一个结点node
            ListNode node = head;
            head = head.next;
            //2. 将node插入已排序部分的适当位置
            if (node.val <= sorted.val) { //Case 1. 待排序的结点小于有序链表的表头，则该结点成为新的表头
                node.next = sorted;
                sorted = node;
            } else { //Case 2，寻找待排序的结点在有序链表中的插入位置
                ListNode temp = sorted;
                while (temp.next != null && temp.next.val < node.val) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
            }
        }
        return sorted;
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
