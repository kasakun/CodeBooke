/**
 * The idea is we put all num in nums to the position 'num - 1' if exists
 * and then iterate the list, if nums[i] != i + 1, then i + 1 will be the
 * answer. 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                // this condition means nums[i] can be put into a right position until we cant
                int temp1 = nums[i], temp2 = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp1;
                nums[i] = temp2;
            }
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        
        return nums.length + 1;
    }
}
