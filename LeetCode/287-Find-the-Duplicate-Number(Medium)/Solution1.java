/**
 * Binary search
 * O(nlogn)
 * The most intuitive way, should be first considered.
 */
 class Solution1 {
    public int findDuplicate(int[] nums) {
        int start = 0, end = nums.length;
        
        while (start <= end) {
            int mid = start + (end - start)/2, count = 0;
            
            for (int num : nums) if (num <= mid) ++count;
            
            if (count <= mid) start = mid + 1;
            else end = mid - 1;
        }
        
        return start;
    }
}