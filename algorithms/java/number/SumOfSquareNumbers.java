package number;

/**
 * Created by Yang on 2017/10/23.
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i*i <= c; i++) {
            double j = Math.sqrt(c - i*i);
            if (j == (int)j) {
                return true;
            }
        }
        return false;
    }
}
