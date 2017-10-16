package number.bit;

/**
 * Created by Yang on 2017/10/9.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1); //此操作将使最低有效位的1置零
            res++;
        }
        return res;
    }
}
