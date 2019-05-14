/**
 * dp[i][j] if front i numbers can make it to j
 */

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        
        int target = 0, sum = 0;
        
        
        for (int num : nums)
            sum += num;
        
        if (sum % 2 == 1) return false;
        
        target = sum/2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        
        // default setting
        dp[0][0] = true;
        
        for (int i = 1; i <= nums.length; ++i)
            dp[i][0] = true;
        
        for (int i = 1; i <= nums.length; ++i) {
            for(int j = 1; j <= target; ++j) {
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                
                if (j - nums[i - 1] >= 0)
                    pick = dp[i - 1][j - nums[i - 1]];
                    
                dp[i][j] = notPick || pick;
            }
        }
        
        return dp[nums.length][target];
        
    }
}