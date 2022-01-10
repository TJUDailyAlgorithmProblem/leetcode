package 贪心算法;

public class _122 {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int[] dayProfit = new int[prices.length];
            for (int i = 1; i < prices.length; i++) {
                dayProfit[i] = prices[i] - prices[i - 1];
                if (dayProfit[i] > 0) {
                    profit += dayProfit[i];
                }
            }
            return profit;
        }
    }
}
