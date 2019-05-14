/**
 * O(N)
 */
class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int left = 0, sum = 0, min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            while (sum >= s && left < nums.length) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left];
                ++left;
            }
        }

        return min == Integer.MAX_VALUE? 0 : min;
    }
}