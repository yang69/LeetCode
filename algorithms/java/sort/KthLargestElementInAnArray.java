package sort;

import java.util.PriorityQueue;

/**
 * Created by Yang on 2017/10/19.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // 用一个最小堆维护前K大的数
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    public int findKthLargestUsingPartition(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        int index = nums.length - k;
        while (lo < hi) {
            int mid = partition(nums, lo, hi);
            if (mid == index) {
                return nums[index];
            } else if (mid > index) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[index];
    }

    private int partition(int[] nums, int lo, int hi) {
        if (nums == null || nums.length == 0 || lo <  0 || hi >= nums.length || lo > hi) {
            throw new RuntimeException("partition: bad parameter...");
        }
        int pivotIndex = lo + (int)(Math.random() * (hi - lo));
        swap(nums, pivotIndex, hi);
        int small = lo - 1;
        for (int i = lo; i < hi; i++) {
            if (nums[i] < nums[hi]) {
                small++;
                if (small != i) {
                    swap(nums, i, small);
                }
            }
        }
        small++;
        swap(nums, hi, small);
        return small;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();

        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{3,5,1,4,2}, 3) + " <---> 3");
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{1,5,1,4,5}, 3) + " <---> 4");
    }
}
