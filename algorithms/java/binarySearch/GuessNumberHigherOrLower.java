package binarySearch;

/**
 * Created by Yang on 2017/10/23.
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int temp = guess(mid);
            if (temp > 0) {
                low = mid + 1;
            } else if (temp < 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int guess(int n) {
        int myNumber = n/2;
        return n == myNumber ? 0 : n > myNumber ? -1 : 1;
    }
}
