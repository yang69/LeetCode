package TEMP;

/**
 * Created by Yang on 2017/10/6.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int minBuyPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            }
            else if(prices[i] - minBuyPrice > maxProfit) {
                maxProfit = prices[i] - minBuyPrice;
            }
        }
        return maxProfit;
    }
}
