/**
 * bottom to up 0 -> target
 * The point is dp[curr] = sum(all dp[prev]) dp[n] is more like how many steps to n
 */

 class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || target == 0) return 0;

        int[] dp = new int[target + 1];
        
        dp[0] = 1;
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        
        return dp[target];
    }
}