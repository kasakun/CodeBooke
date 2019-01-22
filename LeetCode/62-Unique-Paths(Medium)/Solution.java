/**
 * dp
 * 
 * Create a dp[m + 1][n + 1]
 * 
 * The equation:
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        dp[1][0] = 1;
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m][n];
    }
}