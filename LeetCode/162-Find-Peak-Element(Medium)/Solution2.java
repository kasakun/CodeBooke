/**
 * Binary Search
 * 
 */

class Solution2 {
    private int bSearch(int[]nums, int start, int end) {
        if (start == end) return start;
        
        int mid = start + (end - start)/2;
        
        if (nums[mid] > nums[mid + 1])
            return bSearch(nums, start, mid);
        
        return bSearch(nums, mid + 1, end);
    }
    public int findPeakElement(int[] nums) {
        return bSearch(nums, 0, nums.length - 1);
    }
}