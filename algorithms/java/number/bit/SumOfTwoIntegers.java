package number.bit;

/**
 * Created by Yang on 2017/10/23.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        //①各个位的不带进位的和②各个位产生的进位，不带进位的和+进位=最终的和（终止条件为进位为0）
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
