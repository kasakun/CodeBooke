class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        
        int prev = 0, count = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            while (i < nums.length && nums[prev] == nums[i])
                ++i;
            
            if (i < nums.length) {
                nums[prev + 1] = nums[i];
                ++count;
            }
            
            ++prev;
        }
        
        return count;
    }
}