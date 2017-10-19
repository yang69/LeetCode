package list;

/**
 * Created by Yang on 2017/10/19.
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) { //由于无法访问前一个节点，因此不能直接删除当前节点
        node.val = node.next.val; //将下一个节点的值复制到当前节点
        node.next = node.next.next; //删除下一个节点
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
