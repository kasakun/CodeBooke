class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        int size = A.size(), res = INT_MAX;
        if (size == 0) return res;
        vector<int> dp(A[0]);
        
        for (int i = 1; i < size; ++i) {
            vector<int> temp((int)A[i].size());
            for (int j = 0; j < (int)A[i].size(); ++j) {
                if (j == 0)
                    temp[j] = A[i][j] + min(dp[j], dp[j + 1]);
                else if (j == A[i].size() - 1)
                    temp[j] = A[i][j] + min(dp[j], dp[j - 1]);
                else
                    temp[j] = A[i][j] + min(dp[j + 1], min(dp[j], dp[j - 1]));
            }
            
            dp = temp;
        }
        
        for (auto& num : dp)
            res = min(res,  num);
        
        return res;
    }
};

