class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) continue;
            
            int index = i;
            // go to next not zero
            while (index < nums.length && nums[index] == 0) ++index;
            
            if (nums.length == index) break;
            nums[i] = nums[index];nums[index] = 0;
        }
    }
}