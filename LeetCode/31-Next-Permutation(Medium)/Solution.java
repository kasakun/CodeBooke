class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        // from the tail to find a pair which ai < ai-1
        while (i >= 0 && nums[i + 1] <= nums[i])
            --i;

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i])
                --j;
            
            swap(nums, i, j);
        }
        
        // resorted
        reverse(nums, i + 1);
    }
    
    
    /**
     * This method reverse from start to the end of the array
     *
     * @param array
     * @param start index
     */
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        
        while (i < j) {
            swap(nums, i, j);
            ++i;--j;
        }
    }
    
    /**
     * @param array
     * @param index1
     * @param index2
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}