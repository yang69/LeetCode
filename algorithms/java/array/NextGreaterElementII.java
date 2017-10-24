package array;

import java.util.Stack;

/**
 * Created by Yang on 2017/10/24.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        // 从右向左扫面两遍，在栈中保存递减值的索引
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int currentIndex = i % nums.length;
            // 栈顶的数字不大于当前的数字，那么栈顶数字不可能是左侧任何一个值的NextGreatElement
            while (!stack.isEmpty() && nums[currentIndex] >= nums[stack.peek()]) {
                stack.pop();
            }
            res[currentIndex] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(currentIndex);
        }
        return res;
    }
}
