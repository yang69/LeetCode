package number.prime;

/**
 * Created by Yang on 2017/10/11.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n]; //默认初始值为false
        int count = 0; //质数的数量
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        return count;
    }
}
