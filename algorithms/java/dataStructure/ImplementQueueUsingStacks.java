package dataStructure;

import java.util.Stack;

/**
 * Created by Yang on 2017/10/19.
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        while(!a.isEmpty()) {
            b.push(a.pop());
        }
        a.push(x);
        while(!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        a.pop();
    }

    // Get the front element.
    public int peek() {
        return a.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return a.isEmpty();
    }
}
