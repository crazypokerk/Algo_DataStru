package leetcode.Array;

/**
 * @Date 2019/8/28 8:55
 */
public class _121_MaxProfit {
	public int maxProfit(int[] prices) {
		
		int min_price = Integer.MAX_VALUE;
		int max_profit = 0;
		
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min_price) {
				min_price = prices[i];
			} else if (prices[i] - min_price > max_profit) {
				max_profit = prices[i] - min_price;
			}
		}
		return max_profit;
	}
}
