package array;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Yang on 2017/10/24.
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // https://discuss.leetcode.com/topic/77916/java-10-lines-linear-time-complexity-o-n-with-explanation
        HashMap<Integer, Integer> map = new HashMap<>();
        // 单调递减堆
        Stack<Integer> monotoneDecreasingStack = new Stack<>();
        for (int n : nums2) {
            while (!monotoneDecreasingStack.isEmpty() && n > monotoneDecreasingStack.peek()) {
                map.put(monotoneDecreasingStack.pop(), n);
            }
            monotoneDecreasingStack.push(n);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}
