/**
 * dp
 */
class Solution {
    int[] ones, zeros;
    
    public int findMaxForm(String[] strs, int m, int n) {
        ones = new int[strs.length];
        zeros = new int[strs.length];
        
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        
        for (int i = 0; i < strs.length; ++i) {
            for (char c : strs[i].toCharArray()) {
                if (c == '1')
                    ++ones[i];
                else
                    ++zeros[i];
            }
        }
        
        for (int i = 0; i <= strs.length; ++i) {
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= n; ++k) {
                    if (i == 0) dp[i][j][k] = 0;
                    else if (j >= zeros[i - 1] && k >= ones[i - 1])
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],  // not picked
                                               dp[i - 1][j - zeros[i - 1]][k - ones[i - 1]] + 1); // picked
                    else
                        dp[i][j][k] = dp[i - 1][j][k];  // not picked
                }
            }
        }
    
        return dp[strs.length][m][n];
    }
}