package number;

/**
 * Created by Yang on 2017/10/5.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        // https://discuss.leetcode.com/topic/11877/detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
        // x1、x2一起表示32个计数器，x1是这32个计数器的最低位，x2是这32个计数器的最高位，mask保证这32个计数器是3进制的
        int x1 = 0;
        int x2 = 0;
        int mask = 0;

        for(int i : nums) {
            x2 ^= (x1 & i); //此处应先算最高位，因为高位是当前输入和低位的先前状态决定的，如果先算低位，会覆盖先前状态，出现00->01->00这样的错误结果
            x1 ^= i;
            mask = ~(x1 & x2);
            x1 &= mask;
            x2 &= mask;
        }

        return x1;
    }
}
