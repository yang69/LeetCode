package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang on 2017/10/19.
 */
public class ImplementStackUsingQueues {
    Queue<Integer> q = new LinkedList<>();
    // int top;
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        // top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i = 0; i < q.size()-1; i++) {
            q.offer(q.poll());
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        for(int i = 0; i < q.size()-1; i++) {
            q.offer(q.poll());
        }
        int top = q.poll();
        q.offer(top);
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
