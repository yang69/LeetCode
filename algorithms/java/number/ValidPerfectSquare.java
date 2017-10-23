package number;

/**
 * Created by Yang on 2017/10/23.
 */
public class ValidPerfectSquare {
    // https://discuss.leetcode.com/topic/49325/a-square-number-is-1-3-5-7-java-code
    public boolean isPerfectSquare(int num) {
        int lo = 1;
        int hi = num;
        while (lo <= hi) {
            long mid = (lo + hi) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                lo = (int)mid + 1;
            } else {
                hi = (int)mid - 1;
            }
        }
        return false;
    }
}
