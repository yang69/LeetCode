package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yang on 2017/10/4.
 ************************************************************************************************
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 排序
 *  归并：
 *      21. Merge Two Sorted Lists（归并2个有序列表）
 ************************************************************************************************
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 ************************************************************************************************
 */
public class MergeKSortedLists {
    /**
     * 优先队列（最小堆）
     * @param lists
     * @return
     */
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val > o2.val) {
                    return 1;
                }
                return 0;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }
        return dummy.next;
    }

    /**
     * 分而治之
     * 先两两一组，分别合并，每次合并之后，lists的数量减半，如此重复进行，直到只剩下一个链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int amount = lists.length;
        int interval = 1;
        while (interval < amount) {
            for (int i = 0; i < amount - interval; i += 2*interval) {
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(3);
        System.out.print(mergeKSortedLists.mergeKLists(new ListNode[]{l1, l2})
                + " <---> ");
        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l2 = new ListNode(3);
        System.out.println(mergeKSortedLists.mergeKListsPriorityQueue(new ListNode[]{l1,l2}));

        System.out.println(mergeKSortedLists.mergeKLists(
                new ListNode[]{new ListNode(2), null, new ListNode(-1)}) + " <---> -1, 2");
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
