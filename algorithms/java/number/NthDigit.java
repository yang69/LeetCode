package number;

/**
 * Created by Yang on 2017/10/23.
 */
public class NthDigit {
    public int findNthDigit(int n) {
        // 1.找到n位所在的数字是几位数
        int digits = 1; //“几位数”
        long count = 9; //一共有多少位这样的“几位数”
        int start = 1; //“几位数”的第一个数是几
        while ((long) n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }
        // 2.所求的第n位在哪一个数字上
        start += (n - 1) / digits;
        //String s = Integer.toString(start);
        // 3.所求的第n位在这个数字的第几位上
        return Character.getNumericValue(String.valueOf(start).charAt((n - 1) % digits));
    }
}
