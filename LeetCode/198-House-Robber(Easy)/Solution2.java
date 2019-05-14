/**
 * Same with Solution1.java
 * but O(1) space
 */
class Solution {
    public int rob(int[] nums) {
        int prevNo = 0, prevYes = 0;
        
        for (int i : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = i + temp;
        }
        
        return Math.max(prevNo, prevYes);
    }
}