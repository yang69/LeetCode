package dynamicProgramming.knapsackProblem;

/**
 * Created by Yang on 2017/10/3.
 ************************************************************************************************
 * 518. Coin Change 2
 * https://leetcode.com/problems/coin-change-2/
 * 背包问题（http://love-oriented.com/pack/）
 *  416. Partition Equal Subset Sum(01背包，和为target的集合是否存在)
 ************************************************************************************************
 * You are given coins of different denominations and a total amount of money. Write a function
 * to compute the number of combinations that make up that amount. You may assume that you have
 * infinite number of each kind of coin.
 *
 * Example 1:
 *  Input:  amount = 5, coins = [1, 2, 5]
 *  Output: 4
 *  Explanation:
 *      there are four ways to make up the amount:
 *      5=5
 *      5=2+2+1
 *      5=2+1+1+1
 *      5=1+1+1+1+1
 *
 * Example 2:
 *  Input:  amount = 3, coins = [2]
 *  Output: 0
 *  Explanation:
 *      the amount of 3 cannot be made up just with coins of 2.
 *
 * Example 3:
 *  Input:  amount = 10, coins = [10]
 *  Output: 1
 *
 * Note: You can assume that
 *      0 <= amount <= 5000
 *      1 <= coin <= 5000
 *      the number of coins is less than 500
 *      the answer is guaranteed to fit into signed 32-bit integer
 ************************************************************************************************
 */
public class CoinChange2 {
    /**
     * 完全背包问题，与01背包问题的区别在于，dp[i][j]迭代计算的时候，01背包从右向左，完全背包从左向右
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }

        return dp[coins.length][amount];
    }

    public int changeOpt(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[j] = dp[j] + (j >= coins[i-1] ? dp[j-coins[i-1]] : 0);
            }
        }

        return dp[amount];
    }


    public int changeOptReconstruct(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();

        System.out.println(coinChange2.change(5, new int[]{1,2,5})
                + " <---> " + coinChange2.changeOpt(5, new int[]{1,2,5})
                + " <---> " + coinChange2.changeOptReconstruct(5, new int[]{1,2,5}));
        System.out.println(coinChange2.change(3, new int[]{2})
                + " <---> " + coinChange2.changeOpt(3, new int[]{2})
                + " <---> " + coinChange2.changeOptReconstruct(3, new int[]{2}));
    }
}
