package number;

/**
 * Created by Yang on 2017/10/23.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // https://discuss.leetcode.com/topic/34841/java-three-methods-23ms-36-ms-58ms-with-heap-performance-explained
        if (n <= 0 || primes == null || primes.length == 0) {
            throw new IllegalArgumentException("invalid parameters");
        }
        int[] superUglyNumbers = new int[n+1];
        int[] idxs = new int[primes.length];
        superUglyNumbers[0] = 1;
        for (int i = 1; i < n; i++) {
            superUglyNumbers[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                superUglyNumbers[i] = Math.min(superUglyNumbers[i], primes[j] * superUglyNumbers[idxs[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * superUglyNumbers[idxs[j]] <= superUglyNumbers[i]) {
                    idxs[j]++;
                }
            }
        }

        return superUglyNumbers[n-1];
    }
}
