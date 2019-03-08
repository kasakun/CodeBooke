class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        
        for (int i = 1; i <= n; ++i)
            dp[i] = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; ++i) {
            int sqrt = (int)Math.sqrt(i);
            
            if (sqrt*sqrt == i)
                dp[i] = 1;
            
            // current result is previous result + square numbers
            for (int j = 1; j <= sqrt; ++j) {
                int prevIndex = i - j*j;
                dp[i] = Math.min(dp[i], dp[prevIndex] + 1);
            }
        }
        
        return dp[n];
    }
}