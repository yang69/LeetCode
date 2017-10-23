package number;

/**
 * Created by Yang on 2017/10/23.
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) { //二进制表示只有一位1，且这个1不在奇数位上
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
