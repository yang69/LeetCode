package number;

/**
 * Created by Yang on 2017/10/23.
 */
public class CountNumbersWithUniqueDigits {
    // https://discuss.leetcode.com/topic/47983/java-dp-o-1-solution
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 10;
        int uniqueDigits = 9;
        int numAvailable = 9;
        while (n > 1 && numAvailable > 0) {
            uniqueDigits *= numAvailable;
            res += uniqueDigits;
            numAvailable--;
            n--;
        }

        return res;
    }
}
