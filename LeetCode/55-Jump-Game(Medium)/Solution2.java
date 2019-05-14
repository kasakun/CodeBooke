/**
 * Add a memo to memorize the fixed result of each element in the array.
 * The iteration still starts from the top, and then we can only skip
 * the bad mark.
 */
enum Mark {
    GOOD,
    BAD,
    UNKNOWN
}

class Solution2 {
    Mark[] memo;
    
    private boolean canJumpHelper(int position, int[] nums) {
        if (memo[position] != Mark.UNKNOWN) {
            return memo[position] == Mark.GOOD ? true : false;
        }
        
        int maxNextPosition = Math.min(position + nums[position],
                                       nums.length - 1);
        
        for (int nextPosition = position + 1; nextPosition <= maxNextPosition; ++ nextPosition) {
            if (canJumpHelper(nextPosition, nums)) {
                memo[position] = Mark.GOOD;
                return true;
            }
        }
        
        memo[position] = Mark.BAD;
        
        return false;
    }
    
    public boolean canJump(int[] nums) {
        memo = new Mark[nums.length];
        
        for (int i = 0; i < nums.length - 1; ++i) {
            memo[i] = Mark.UNKNOWN;
        }
        
        memo[nums.length - 1] = Mark.GOOD;
        
        return canJumpHelper(0, nums);
    }
}