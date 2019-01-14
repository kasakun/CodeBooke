/**
 * Dp
 * O(logn^2)
 */
class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            int temp = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + 1;
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}