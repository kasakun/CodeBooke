/**
 * dp[i][k] represents result of first i with k subsets
 * 
 * iterate k
 * then with fixed k, we update dp[i][k] from i = k to K since we cannot split it if k > i
 * to update dp[i][k]
 * dp[i][k] = max(dp[i][k], dp[j][k - 1] + (sum[i] - sum[j])/(i - j))
 */
class Solution {
public:
    double largestSumOfAverages(vector<int>& A, int K) {
        int size = A.size();
        vector<int> sum(size + 1, 0);
        for (int i = 0; i < size; ++i)
            sum[i + 1] = sum[i] + A[i];
        
        // corner case
        if (K <= 1) return 1.0*sum[size]/size;
        if (K >= size) return 1.0*sum[size];
        
        vector<vector<double>> dp(size + 1, vector<double>(K + 1, 0.0));
        
        //initialize
        for (int i = 1; i <= size; ++i)
            dp[i][1] = 1.0*sum[i]/i;
        
        for (int k = 2; k <= K; ++k) {
            for (int i = k; i <= size; ++i) {
                for (int j = i - 1; j >= k - 1; --j)
                    dp[i][k] = max(dp[i][k], dp[j][k - 1] + 1.0*(sum[i] - sum[j])/(i - j));
            }
        }
        
        return dp[size][K];
    }
};

