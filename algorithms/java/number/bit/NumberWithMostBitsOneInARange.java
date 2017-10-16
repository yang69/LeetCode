package number.bit;

/**
 * Created by Yang on 2017/10/14.
 * 触宝2018秋招-2017.10.14后端
 * 对于一个正整数，认为它的光棍指数是它的二进制表示下的1的个数。通常认为光棍指数越高，这个数就越孤单。
 * 找出给定区间[lo, hi]中最孤单的数。（光棍指数相同时，越小的数越孤单）
 */
public class NumberWithMostBitsOneInARange {
    /**
     * 第一个候选数字是区间的左侧端点值，从最低位开始，依次尝试将当前比特设置为1，
     * 如果由此得到的值在区间范围内，就找到了一个拥有更多比特1的数字。
     * PS: 如果需要返回具有最多比特1的数字（大数优先），那只需要改从最高位开始设置比特。
     * @param lo
     * @param hi
     * @return
     */
    public int getNumberWithMostBitsOne(int lo, int hi) {
        int res = lo;
        for (int i = 0; i < 32; i++) {
            int candidate = res | (1 << i);
            if (candidate >= lo && candidate <= hi) {
                res = candidate;
            }
        }

        return res;
    }

    public int getNumberWithMostBitsOneBruteForce(int lo, int hi) {
        int res = lo;
        int max = numberOfBitsOne(lo);
        for (int i = lo + 1; i <= hi; i++) {
            int currentBits = numberOfBitsOne(i);
            if (currentBits > max) {
                res = i;
                max = currentBits;
            }
        }

        return res;
    }

    private int numberOfBitsOne(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1); //此操作将使最低有效位的1置零
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        NumberWithMostBitsOneInARange numberWithMostBitsOneInARange = new NumberWithMostBitsOneInARange();

        System.out.println(numberWithMostBitsOneInARange.getNumberWithMostBitsOne(0, 14)
                + " <---> " + numberWithMostBitsOneInARange.getNumberWithMostBitsOneBruteForce(0, 14));
        System.out.println(numberWithMostBitsOneInARange.getNumberWithMostBitsOne(100, 1000)
                + " <---> " + numberWithMostBitsOneInARange.getNumberWithMostBitsOneBruteForce(100, 1000));
        System.out.println(numberWithMostBitsOneInARange.getNumberWithMostBitsOne(2532, 8569421)
                + " <---> " + numberWithMostBitsOneInARange.getNumberWithMostBitsOneBruteForce(2532, 8569421));
    }
}
