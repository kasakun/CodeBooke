/**
 * Binary search
 */ 
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int size = nums.size();
        if (size == 0) return -1;
        
        int start = 0, end = size - 1;
        
        while (start < end) {
            int mid = start + (end - start)/2;
            
            if (nums[mid] == target) return mid;
            
            if (nums[start] <= nums[mid]) {
                // start-mid is normal
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else
                    start = mid + 1;
            }else {
                // mid-end is normal
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else
                    end = mid - 1;
            }
        }
        
        
        return nums[start] == target ? start : -1;
    }
};

