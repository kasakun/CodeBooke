class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int index = 0, valley = prices[0], peak = prices[0], maxProfit = 0;
        
        while (index < prices.length - 1) {
            while (index < prices.length - 1 && prices[index] >= prices[index + 1])
                ++index;
            valley = prices[index];
            
            while (index < prices.length - 1 && prices[index] <= prices[index + 1])
                ++index;
            peak = prices[index];
            
            maxProfit += (peak - valley);
        }
        
        return maxProfit;
    }
}