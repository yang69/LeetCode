import java.util.HashSet;

/**
 * Created by Yang on 2017/9/28.
 ************************************************************************************************
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 *
 * Example 1:
 *  Input:  [3, 10, 5, 25, 2, 8]
 *  Output: 28
 *  Explanation:
 *      The maximum result is 5 ^ 25 = 28.
 *
 * Following:
 *      Maximum Xor Secondary
 ************************************************************************************************
 */
public class MaximumXOROfTwoNumbersInAnArray {
    // https://discuss.leetcode.com/topic/63213/java-o-n-solution-using-bit-manipulation-and-hashmap
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public int findMaximumXORBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumXOROfTwoNumbersInAnArray mxotniaa = new MaximumXOROfTwoNumbersInAnArray();

        System.out.println(mxotniaa.findMaximumXOR(new int[]{3,10,5,25,2,8})
                + " <---> " + mxotniaa.findMaximumXORBruteForce(new int[]{3,10,5,25,2,8}));
    }
}
