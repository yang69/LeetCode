package list;

/**
 * Created by Yang on 2017/10/9.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;//pA先遍历A，之后遍历B
        ListNode pB = headB;//pB先遍历B，之后遍历A
        while (pA != null || pB != null) {
            if (pA == null) pA = headB;//pA先遍历A，之后遍历B
            if (pB == null) pB = headA;//pB先遍历B，之后遍历A
            if (pA == pB) return pA;//到交叉点时，pA与pB相等
            pA = pA.next;
            pB = pB.next;
        }
        return null;
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
