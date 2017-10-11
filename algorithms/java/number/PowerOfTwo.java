package number;

/**
 * Created by Yang on 2017/10/9.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n < 1 ? false : (n&(n-1)) == 0 ? true : false;
    }
}
