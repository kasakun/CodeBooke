/**
 * when 1 comes jump like:
 * 00->01->10->00
 * when 0 comes, hold
 *
 * we can deduct logic expression
 */
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        
        for (int num : nums) {
            int prev_a = a, prev_b = b;

            a = (~num & prev_a & ~prev_b)|(num & ~prev_a & prev_b);
            b = (~num & ~prev_a & prev_b)|(num & ~prev_a & ~prev_b);
        }
        
        return b;
    }
}