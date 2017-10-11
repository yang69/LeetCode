package dynamicProgramming;

import java.util.Stack;

/**
 * Created by Yang on 2017/10/8.
 */
public class LargestRectangleInHistogram {
    // http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        // 单调递增栈
        // 保存heights数组的元素的索引，栈中的元素总是递增的
        // 对于栈顶元素，它的左侧更高的条目都已经计算过，因此，保存在栈中的前一个元素就是它的左边界
        // 它的右边界是不满足压入条件（高度小于栈顶元素）的bar
        Stack<Integer> monotoneIncreasingStack = new Stack<>();
        monotoneIncreasingStack.push(-1); // 0号bar的左边界是-1
        for (int i = 0; i < n; i++) {
            if (monotoneIncreasingStack.peek() == -1 || heights[i] > heights[monotoneIncreasingStack.peek()]) {
                monotoneIncreasingStack.push(i); // 只有递增的bar的索引才会压入栈中
            } else {
                // 碰到一个更小的bar，那它会成为栈顶元素所形成的长方形的右边界
                while (monotoneIncreasingStack.peek() != -1 && heights[i] < heights[monotoneIncreasingStack.peek()]) {
                    // 弹出栈顶元素，它所对应的bar是由栈中前一元素作为左边界、当前height[i]作为右边界的长方形中的最小值
                    int top = monotoneIncreasingStack.pop();
                    // 左边界是栈中的前一个元素，宽度是右边界索引 - 左边界索引 - 1
                    int width = i - monotoneIncreasingStack.peek() - 1;
                    int areaWithTopAsLoweast = heights[top] * width;
                    maxArea = Math.max(maxArea, areaWithTopAsLoweast);
                }
                monotoneIncreasingStack.push(i);
            }
        }
        while (monotoneIncreasingStack.peek() != -1) {
            int top = monotoneIncreasingStack.pop();
            int width = n - monotoneIncreasingStack.peek() - 1;
            int areaWithTopAsLoweast = heights[top] * width;
            maxArea = Math.max(maxArea, areaWithTopAsLoweast);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();

        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2,1,5,6,2,3}) + " <---> 10");
    }
}
