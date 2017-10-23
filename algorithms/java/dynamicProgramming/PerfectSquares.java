package dynamicProgramming;

/**
 * Created by Yang on 2017/10/23.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; i - j*j >= 0; j++) {
                min = Math.min(min, dp[i- j*j] + 1);
            }
            dp[i] = min;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();

        System.out.println(perfectSquares.numSquares(12) + " <---> 3");
        System.out.println(perfectSquares.numSquares(13) + " <---> 2");
    }
}
