class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    /**
     * return k th in [start, end]
     */
    private int quickSelect(int[] nums, int start, int end, int k) {
        int i = start, j = end;
        int pivot = nums[start + (end - start)/2];
        
        while (i <= j) {
            while (i <= j && nums[i] > pivot) ++i;
            while (i <= j && nums[j] < pivot) --j;
            
            if (i <= j) {
                swap(nums, i, j);
                ++i; --j;
            }
        }
        
        if (start + k - 1 <= j) return quickSelect(nums, start, j, k);
        if (start + k - 1 >= i) return quickSelect(nums, i, end, k - (i - start));
        // the found is j + 1 or i - 1
        // finally -> j, target, i
        return nums[j + 1];
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
}