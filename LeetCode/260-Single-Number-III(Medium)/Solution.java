class Solution {
    public int[] singleNumber(int[] nums) {
        int factor = 0;
        int[] res = new int[2];
        
        for (int num : nums) {
            factor ^= num;
        }
        
        // get the rightmost set bit
        // two distinct number is different at this bit. 0 or 1
        factor ^= -factor;
        
        for (int num : nums) {
           if ((factor & num) == 0) {
               res[0] ^= num;
           } else {
               res[1] ^= num;
           }
        }
        
        return res;
    }
}