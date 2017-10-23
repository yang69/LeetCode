package number;

/**
 * Created by Yang on 2017/10/23.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) { //32位整形int能表示的最大的3的幂数是3^19=1162261467
        return n > 0 && 1162261467 % n == 0; //3^19=1162261467
    }

    public boolean isPowerOfThreeUsingLoop(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
