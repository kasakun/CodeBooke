/**
 * 
 * Split the circle into two linear list.
 */
class Solution {
    private int rob(int[] nums, int start, int end) {
        int include = 0, exclude = 0;
        
        for (int i = start; i <= end; ++i) {
            int includeTemp = include, excludeTemp = exclude;
            
            // prev must be excluded
            include = excludeTemp + nums[i];
            //prev can be excluded or included
            exclude = Math.max(includeTemp, excludeTemp);
        }
        
        return Math.max(include, exclude);
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}