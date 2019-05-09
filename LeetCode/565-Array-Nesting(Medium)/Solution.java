/**
 * Since it is a complete mapping.
 * There is only one way to visit a element in the array.
 */
class Solution {
    public int arrayNesting(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == -1) continue;
            
            int j = i, step = 0;
            
            while (nums[j] != -1) {
                int index = nums[j];
                nums[j] = -1;
                j = index;
                ++step;
            }
            
            max = Math.max(max, step);
        }
        
        return max;
    }
}