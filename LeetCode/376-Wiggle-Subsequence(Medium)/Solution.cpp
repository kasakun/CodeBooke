/**
 * up - length of longest subseq with last up so far
 * down - length of longest subseq with last down so far
 *
 */ 
class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        int size = nums.size();
        if (size == 0) return 0;
        int up = 1, down = 1;
        
        for (int i = 1; i < size; ++i) {
            if (nums[i] > nums[i - 1])
                down = up + 1;
            else if (nums[i] < nums[i - 1])
                up = down + 1;
        }
        
        return max(up, down);
    }
};

