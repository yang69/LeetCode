package list;

import java.util.HashMap;

/**
 * Created by Yang on 2017/10/9.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode curr = head;
        head = newHead;
        RandomListNode newNode;
        while (curr != null) {
            if (curr.next == null) {
                head.next = null;
            } else {
                if (!map.containsKey(curr.next)) {
                    newNode = new RandomListNode(curr.next.label);
                    map.put(curr.next, newNode);
                }
                head.next = map.get(curr.next);
            }

            if (curr.random == null) {
                head.random = null;
            } else {
                if (!map.containsKey(curr.random)) {
                    newNode = new RandomListNode(curr.random.label);
                    map.put(curr.random, newNode);
                }
                head.random = map.get(curr.random);
            }

            curr = curr.next;
            head = head.next;
        }
        return newHead;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
