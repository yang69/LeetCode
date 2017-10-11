package dataStructure;

import java.util.Stack;

/**
 * Created by Yang on 2017/10/9.
 */
public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x <= min) { //如果压入栈的数会改变最小值的话，就将原来的最小值压入，再压入待压入的值
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min) min = stack.pop();//如果弹出的数等于最小值，说明还有一个原最小值备份需要弹出并恢复
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
