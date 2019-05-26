class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        
        for (int i = 0; i < prices.length; ++i) {
            // cash[i - 1], hold[i - 1] + prices[i] - fee
            cash = Math.max(cash, hold + prices[i] - fee);
            // hold[i - 1], cash[i] - prices[i]
            hold = Math.max(hold, cash - prices[i]);
        }
        
        return cash;
    }
}