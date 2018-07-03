package easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        boolean have = false;
        int price = 0;
        int profit = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prices[i] < prices[i+1] && !have){ // 明天涨了，手里没有股票，买
                price = prices[i];
                profit -= price;
                have = true;
            }else if (prices[i] > prices[i+1] && have){ // 明天降了，手里有股票，卖
                profit += prices[i];
                have = false;
            }
        }
        if (have) profit += prices[n-1];

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
        int[] a = {1,2,3,4,5};
        System.out.println(b.maxProfit(a));
    }

}
