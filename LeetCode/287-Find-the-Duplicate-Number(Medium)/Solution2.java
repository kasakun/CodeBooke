/**
 * O(n)
 *
 * State of art solution. anyway I dont see it is necessary to remember.
 * especially for the interview
 */
class Solution2 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        int ptr1 = nums[0], ptr2 = slow;
        
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }
}