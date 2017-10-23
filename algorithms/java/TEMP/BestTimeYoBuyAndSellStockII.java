package TEMP;

/**
 * Created by Yang on 2017/10/6.
 */
public class BestTimeYoBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[i-1] > 0) maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }
}