class Solution {
public:
    int minMoves2(vector<int>& nums) {
        int res = 0, size = nums.size();;
        sort(nums.begin(), nums.end());
        
        for (int i = 0; i < size/2; ++i)
            res += nums[size - 1 - i] - nums[i];
        
        return res;
    }
};

