/**
 * dont think this is easy though...
 */ 
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        vector<int> dp(nums.size(), 0);
        
        dp[0] = nums[0];
        int res = nums[0];
        
        for (int i = 1; i < nums.size(); ++i) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            res = max(res, dp[i]);
        }
        
        return res;
    }
};

