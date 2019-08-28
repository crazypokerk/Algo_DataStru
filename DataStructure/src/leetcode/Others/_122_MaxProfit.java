package leetcode.Others;

/**
 * @Date 2019/8/28 9:14
 */
public class _122_MaxProfit {
	public int maxProfit(int[] prices) {
		int profit = 0;
		
		for (int i = 1; i < prices.length; i++) {
			int temp = prices[i] - prices[i - 1];
			if (temp > 0) {
				profit += temp;
			}
		}
		return profit;
	}
}
