/**
 * Differnce with Solution2: from bottom.
 * Eliminating stack caused by recursion.
 */
enum Mark {
    GOOD,
    BAD,
    UNKNOWN
}
class Solution3 {
    public boolean canJump(int[] nums) {
        Mark[] memo = new Mark[nums.length];
        
        for (int i = 0; i < nums.length - 1; ++i) {
            memo[i] = Mark.UNKNOWN;
        }
        memo[nums.length - 1] = Mark.GOOD;
        
        for (int i = nums.length - 2; i >= 0; --i) {
            int maxNextJump =  Math.min(i + nums[i], nums.length - 1);
            
            for (int j = i + 1; j <= maxNextJump; ++j) {
                if (memo[j] == Mark.GOOD) {
                    memo[i] = Mark.GOOD;
                    break;
                }
            }
        }
        
        return memo[0] == Mark.GOOD;
    }
}