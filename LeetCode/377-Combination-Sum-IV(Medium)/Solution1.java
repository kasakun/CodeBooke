/**
 * Up to down, target -> 0
 */
 class Solution1 {
    private int[] dp;

    private int helper(int[] nums, int remain) {
        if (dp[remain] != -1) return dp[remain];

        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (remain >= nums[i])
                res += helper(nums, remain - nums[i]);
        }
        
        dp[remain] = res;
        
        return dp[remain];
        
    }
    
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || target == 0) return 0;

        dp = new int[target + 1];
        
        dp[0] = 1;
        for (int i = 1; i < dp.length; ++i)
            dp[i] = -1;
        
        return helper(nums, target);
    }
}