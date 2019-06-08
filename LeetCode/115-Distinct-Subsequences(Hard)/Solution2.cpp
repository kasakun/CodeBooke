/**
 * dp
 */ 
class Solution {
public:
    int numDistinct(string s, string t) {
        int rows = t.size(), cols = s.size();
        
        long dp[rows + 1][cols + 1] = {{0}};
        
        memset(dp, 0, sizeof(dp));
        
        for (int i = 0; i <= cols; ++i) dp[0][i] = 1;
        
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                if (t[i - 1] == s[j - 1])
                    // prev + now with character
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }
        
        return dp[rows][cols];
    }
};
