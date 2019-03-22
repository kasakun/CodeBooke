class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        
        for (int num : nums) {
            b = b ^ num & ~a;
            a = a ^ num & ~b;
        }
        
        return b;
    }
}