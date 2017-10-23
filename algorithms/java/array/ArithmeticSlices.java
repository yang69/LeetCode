package array;

/**
 * Created by Yang on 2017/10/23.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        // https://discuss.leetcode.com/topic/62992/3ms-c-standard-dp-solution-with-very-detailed-explanation/2
        int[] diffs = new int[A.length - 1];
        for (int i = 0; i < diffs.length; i++) {
            diffs[i] = A[i + 1] - A[i];
        }
        int curr = 0;
        int sum = 0;
        for (int i = 0; i < diffs.length - 1; i++) {
            if (diffs[i] == diffs[i + 1]) {
                curr++;
                sum += curr;
            } else {
                curr = 0;
            }
        }
        return sum;
    }
}
