import java.util.Stack;

/**
 * Created by Yang on 2017/9/28.
 ************************************************************************************************
 * Maximum Xor Secondary
 * http://codeforces.com/problemset/problem/280/B
 * http://gautamimp.blogspot.com/2016/02/d-maximum-xor-secondary-find-max-and.html
 ************************************************************************************************
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * Find the maximum result of ai XOR aj, where ai是包含ai和aj的子数组中的最大值，aj是同一个子数组
 * 的严格次大值，ai != aj，0 ≤ i, j < n.
 *
 * Example 1:
 *  Input:  [5, 2, 1, 4, 3]
 *  Output: 7
 *  Explanation:
 *      The maximum result is 5 ^ 2 from [5, 2] = 7.
 ************************************************************************************************
 */
public class MaximumXorSecondary {
    public int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        // 单调递减堆
        Stack<Integer> monotoneDecreasingStack = new Stack<>();
        for (int num : nums) {
            while (!monotoneDecreasingStack.isEmpty()) {
                if (num > monotoneDecreasingStack.peek()) { // 当前数字将取代前一个数成为最大值或次大值
                    max = Math.max(max, num ^ monotoneDecreasingStack.peek());
                    monotoneDecreasingStack.pop(); // 前一个数被当前数字取代
                } else if (num < monotoneDecreasingStack.peek()) { // 当前数字将成为前一个数开头的子数组的次大值
                    max = Math.max(max, num ^ monotoneDecreasingStack.peek());
                    break;
                } // 与栈顶值相等的数不可能成为最大值或严格次大值
            }
            monotoneDecreasingStack.push(num);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumXorSecondary maximumXorSecondary = new MaximumXorSecondary();

        System.out.println(maximumXorSecondary.findMaximumXOR(new int[]{5, 2, 1, 4, 3}) + " <---> 7");
        System.out.println(maximumXorSecondary.findMaximumXOR(new int[]{9, 8, 3, 5, 7}) + " <---> 15");
    }
}
