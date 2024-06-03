package Blind75.ArrayHashingBinarySearch;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i<prices.length;i++) {
            int currentPrice = prices[i];
            if (buyPrice > currentPrice) {
                buyPrice = currentPrice;
            }
            profit = Math.max(profit, currentPrice - buyPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,6,4};
        int max_profit = BuyAndSellStock.maxProfit(prices);
        System.out.println(max_profit);
    }
}
