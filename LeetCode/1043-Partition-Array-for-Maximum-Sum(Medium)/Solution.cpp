class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& A, int K) {
        vector<int> dp(A.size());
        
        for (int i = 0; i < A.size(); ++i) {
            int currMax = 0;
            //A[i - k + 1] ... A[i], pick k vals in this partition
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                currMax = max(currMax, A[i - k + 1]);
                dp[i] = max(dp[i], ((i - k) >= 0 ? dp[i - k] : 0) + currMax*k);
            }
        }
        
        return dp.back();
    }
};