package number;

/**
 * Created by Yang on 2017/10/19.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return -1;
        }
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int times2 = 0;
        int times3 = 0;
        int times5 = 0;
        for (int i = 1; i < n; i++) {
            uglyNumbers[i] = Math.min(2 * uglyNumbers[times2], Math.min(3 * uglyNumbers[times3], 5 * uglyNumbers[times5]));
            if (uglyNumbers[i] == 2 * uglyNumbers[times2]) {
                times2++;
            }
            if (uglyNumbers[i] == 3 * uglyNumbers[times3]) {
                times3++;
            }
            if (uglyNumbers[i] == 5 * uglyNumbers[times5]) {
                times5++;
            }
        }
        return uglyNumbers[n - 1];
    }
}
