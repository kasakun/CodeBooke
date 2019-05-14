/**
 * Greedy
 */
class Solution {
    public int jump(int[] nums) {
        int step = 0;
        
        for (int start = 0, end = 0; end < nums.length - 1; ++step) {
            int newEnd = 0;
            for (int i = start; i <= end; ++i)
                newEnd = Math.max(newEnd, i + nums[i]);
            
            start = end + 1;
            end = newEnd;
        }    
        return step;
    }
}