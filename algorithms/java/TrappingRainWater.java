import java.util.Stack;

/**
 * Created by Yang on 2017/8/1.
 *
 * https://leetcode.com/problems/trapping-rain-water/
 ************************************************************************************************
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Example:
 *  Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 *  Output: 6
 ************************************************************************************************
 */
public class TrappingRainWater {
    public int trap1(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            int maxLeft = height[i];
            for (int j = 0; j < i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            int maxRight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            res += Math.min(maxLeft, maxRight) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int res = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for (int i = 1; i < height.length; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
    }

    public int trap3(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int boundedHeight = Math.min(height[stack.peek()], height[current]) - height[top];
                int distance = current - stack.peek() - 1;
                res += boundedHeight * distance;
            }
            stack.push(current++);
        }
        return res;
    }

    public int trap4(int[] height) {
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        int lo = 0;
        int hi = height.length - 1;
        while (lo < hi) {
            leftMax = Math.max(leftMax, height[lo]);
            rightMax = Math.max(rightMax, height[hi]);
            if (leftMax < rightMax) {
                for (int i = lo + 1; i <= hi; i++) {
                    if (height[i] < leftMax) {
                        res += leftMax - height[i];
                    } else {
                        lo = i;
                        break;
                    }
                }
            } else {
                for (int i = hi - 1; i >= lo; i--) {
                    if (height[i] < rightMax) {
                        res += rightMax - height[i];
                    } else {
                        hi = i;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
