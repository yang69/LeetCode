package number;

/**
 * Created by Yang on 2017/10/23.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        // 方法就是尽量拆成3
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
        }
        res *= n;

        return res;
    }
}
