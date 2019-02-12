/**
 * Consider you are a trader and make decision everyday corresponding to index.
 * 
 * For each day/index, you get a price.
 * 
 * only 2 questions are required.
 * 
 * 1.Is it a min price so far?
 * If yes, there is no need to update max profit, since you lose money.
 * 2.If not, do we need to update the max profit?
 * 
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        
        return maxProfit;
    }
}