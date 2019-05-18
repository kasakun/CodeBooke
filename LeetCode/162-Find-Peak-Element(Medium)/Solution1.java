class Solution1 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (prev > nums[i]) return (i - 1);
            
            prev = nums[i];
        }
        
        return nums.length - 1;
    }
}