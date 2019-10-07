class Solution {
public:
    int maxA(int N) {
        int dp[N + 1] = {0};

        for (int i = 1; i <= N; ++i) {
            dp[i] = dp[i - 1] + 1;

            // check each possible slot to i - 2
            // since we have to use 1 to select all, 1 to copy
            // [0],[0,1], [0,1,2]
            for (int j = 0; j < i - 1; ++j)
                dp[i] = max(dp[i], dp[j]*(i - j - 1));
        }

        return dp[N];
    }
};

