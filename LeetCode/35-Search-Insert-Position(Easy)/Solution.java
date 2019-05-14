/**
 * Binary Search
 * Time O(logn)
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if(target > nums[high]) 
            return high + 1;
        
        while(low < high - 1){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid;
            else low = mid;
        }
        
        if(target == nums[low]) 
            return low;
        else if(target > nums[low]) 
            return low + 1;
        else 
            return 0;
    }
}