/**
 * The idea is DFS.
 * This solution now will lead to time limit exceeds.
 */
class Solution1 {
    private boolean canJumpHelper(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        
        int maxNextPosition = Math.min(position + nums[position],
                                       nums.length - 1);
        
        for (int nextPosition = position + 1; nextPosition <= maxNextPosition; ++ nextPosition) {
            if (canJumpHelper(nextPosition, nums)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean canJump(int[] nums) {
        return canJumpHelper(0, nums);
    }
}