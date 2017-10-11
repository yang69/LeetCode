package number;

/**
 * Created by Yang on 2017/10/11.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        if (slow == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int digitSquareSum(int n) {
        int sum = 0, temp;
        while (n != 0) {
            temp = n % 10;
            n = n / 10;
            sum += temp * temp;
        }
        return sum;
    }
}
