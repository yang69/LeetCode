package array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Yang on 2017/10/19.
 */
public class SlidingWindowMaximum {
    /**
     * 也是剑指offer第65题
     * https://github.com/yang69/AtOffer/blob/master/src/MaxInSlidingWindow.java
     * 【解】：用一个双端队列
     *    队列里存的是数组元素的下标
     *    当前队列头永远放的是当前窗口的最大值；后面的元素依次是，前一个元素滑出窗口后，滑动窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }
        int n = nums.length;
        int[] maxs = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        // 处理第一个窗口
        for (int i = 0; i < k; i++) {
            // 比新进入滑动窗口的元素小的值都不再可能是滑动窗口的最大值，将这些元素都弹出
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        // 滑动窗口，窗口最大值在index的队首
        for (int i = k; i < n; i++) {
            maxs[i-k] = nums[dq.peekFirst()];
            // 比新进入滑动窗口的元素小的值都不再可能是滑动窗口的最大值，将这些元素都弹出
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            // 如果队首元素已经不在当前滑动窗口中，将之弹出
            if (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
        }
        maxs[maxs.length - 1] = nums[dq.peekFirst()];
        return maxs;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        for (int n : slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)) {
            System.out.print(n + " ");
        }
        System.out.println("<---> 3 3 5 5 6 7");
    }
}
