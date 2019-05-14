/**
 * The idea is that when use binary search, there is always a sorted half.
 * Then we check the target if falls in this part, if not we check the other
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (nums[mid] == target) {
                return true;
            }
            // mid...end sorted
            else if (nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            // start..mid sorted
            else if (nums[end] < nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            // exclude end if duplicated. 
            else {
                --end;
            }
            
        }
        
        return false;
    }
}