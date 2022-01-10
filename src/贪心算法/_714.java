package 贪心算法;

public class _714 {
     class Solution {
        public  int maxProfit(int[] prices, int fee) {
            int profit = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                } else {
                    if (prices[i] - min - fee > 0) {
                        profit += prices[i] - min - fee;
                        min=prices[i]-fee;
                    }
                }
            }
            return profit;
        }
    }
}
