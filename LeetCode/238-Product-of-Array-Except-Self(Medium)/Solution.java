class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        res[0] = 1;
        
        // left to right
        for (int i = 1; i < nums.length; ++i)
            res[i] = res[i - 1]*nums[i - 1];
        
        //right to left
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            res[i] *= temp;
            temp *= nums[i];
        }
        
        return res;
    }
}