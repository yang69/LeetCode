package number.bit;

import java.util.Arrays;

/**
 * Created by Yang on 2017/8/25.
 ************************************************************************************************
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *  Input:  5
 *  Output: [0,1,1,2,1,2]
 ************************************************************************************************
 */
public class CountingBits {
    /**
     * 偶数右移一位（相当于/2），二进制中1的个数不变
     * 奇数右移一位（相当于/2），二进制中1的个数减一（丢失最低位的1）
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] numOfDigit1 = new int[num+1];
        for (int i = 1; i <= num; i++) {
            numOfDigit1[i] = numOfDigit1[i >> 1] + (i & 1);
        }
        return numOfDigit1;
    }

    /**
     * 对于二进制数，1位的有2个，2位的有4个（十位是0的有2个），3位的有8个（百位是0的有4个）
     * 当n位二进制数的最高位从0变为1后，二进制中1的数量就比相应的0打头的数多1（这两个数之间相差2^(n-1)）
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
         int[] res = new int[num+1];
         Arrays.fill(res, 0);  // 初始化
         int step = 1;
         int lastNumProcessed = 1;
         while (num + 1 >= lastNumProcessed) {
             for (int i = 0; i < step; i++) {
                 if (lastNumProcessed + i > num) {
                     break;
                 }
                 res[lastNumProcessed + i] = res[lastNumProcessed - step + i] + 1;
             }
             lastNumProcessed += step;
             step <<= 1;
         }

         return res;
    }
}
