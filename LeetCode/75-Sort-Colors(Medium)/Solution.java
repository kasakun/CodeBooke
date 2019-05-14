/**
 * There is a 2-pass solution which is counting 0, 1, 2 in the first loop.
 * Then modify the value in the second loop.
 * 
 * Here we show up a 1-pass solution which is more efficient.
 */
class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, index = 0;
        
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                ++p1;
            }
            
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                --p2;
                --index;
            }
            
            ++index;
        }
    }
}