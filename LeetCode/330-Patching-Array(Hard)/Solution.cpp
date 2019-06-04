/**
 * The idea is simple. DP
 * 
 * 1 2 5 9, n=30
 * 
 * max = 0
 * 
 * 1. [1] 1~1 max = 1
 * 2. [1, 2] 1~3 2 <= prev_max + 1, thus we do not need to patch
 * 3. [1, 2] 1~3 5 > prev_max + 1, needs patch, just patch prev_max + 1
 *                                 update max = prev_max + prev_max + 1 (attach 4)
 * 
 * 4. [1,2] ,[4] 1~7 5 <= prev_max + 1(7) do not need to patch, update max(12)
 * 5. [1,2,5], [4] 1~12 9 <= prev_max + 1  do not need to patch, update max(21)
 * 6. [1,2,5,9], [4] 1~21 no nums to iterate just keep patching prev_max + 1 to exceed it.
 * 
 */
class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        int count = 0, i = 0;
        long long maxNum = 0;
        
        while (maxNum < n) {
            // covered
            if (i < nums.size() && nums[i] <= maxNum + 1) {
                maxNum += nums[i++];
            }
            else {
                maxNum += maxNum + 1;
                ++count;
            }
        }
        
        return count;
    }
};