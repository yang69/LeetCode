import java.util.Arrays;

/**
 * Created by Yang on 2017/4/27.
 ************************************************************************************************
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n
 * as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 *
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4.
 *
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 ************************************************************************************************
 */
public class ArrayPartitionI {
    /**
     * 假设ai <= bi ， 那么，min(ai, bi)的总和就是{ai}, i = 1...n 的和
     * 再假设a1 <= a2 <= ... <= an。
     * 如果b1 > a2 的话，交换b1、a2，则min(a1, a2) = a1， min(b1, b2) >= a1, min(ai, bi)的总和将增加。
     * 归纳推理可以得到，min(ai, bi)总和最大的时候，必然有a1 <= b1 <= a2 <= b2 ... <= an <= bn
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        assert (nums.length & 1) == 0 : "输入的整数个数不是2n";
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }

        return sum;
    }

    /**
     * 所有数值的范围为[-10000, 10000]，所以可以用hash表来记录每一个数字出现的次数，
     * 这样可以改进排序的时间效率为O(n)
     * @param nums
     * @return
     */
    public int arrayPairSum1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        assert (nums.length & 1) == 0 : "输入的整数个数不是2n";
        int[] hashtable = new int[20001];
        for (int num : nums) {
            hashtable[num+10000]++;
        }
        int sumOfPairs = 0;
        int numOfPairs = nums.length >> 1;
        int i = 0;
        while (numOfPairs-- > 0) { // 遍历n对数（ai,bi），令ai <= bi
            while (hashtable[i] == 0) { // 找到ai，并累加之
                i++;
            }
            sumOfPairs += (i-10000);
            hashtable[i]--;
            while (hashtable[i] == 0) { // 找到bi，跳过它
                i++;
            }
            hashtable[i]--;
        }
        return sumOfPairs;
    }

    public static void main(String[] args) {
        ArrayPartitionI arrayPartitionI = new ArrayPartitionI();

        int[] array = new int[]{};
        System.out.print(arrayPartitionI.arrayPairSum(array) + " <--> ");
        System.out.println(arrayPartitionI.arrayPairSum1(array));

        array = new int[]{1,4,3,2};
        System.out.print(arrayPartitionI.arrayPairSum(array) + " <--> ");
        System.out.println(arrayPartitionI.arrayPairSum1(array));

        array = new int[]{1,2,3,2};
        System.out.print(arrayPartitionI.arrayPairSum(array) + " <--> ");
        System.out.println(arrayPartitionI.arrayPairSum1(array));
    }
}
