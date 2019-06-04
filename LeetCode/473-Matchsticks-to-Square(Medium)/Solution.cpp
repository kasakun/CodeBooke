class Solution {
private:
    bool dfs(vector<int>& nums, vector<int>& side, int sideLength, int index) {
        if (index == nums.size()) {
            return (side[0] == side[1]) && (side[1] == side[2]) &&
                   (side[2] == side[3]);
        }
        
        int currLength = nums[index];
        
        for (int i = 0; i < 4; ++i) {
            if (side[i] + currLength <= sideLength) {
                side[i] += currLength;
                if (dfs(nums, side, sideLength, index + 1))
                    return true;
                side[i] -= currLength;
            }
        }
        
        return false;
    }
public:
    bool makesquare(vector<int>& nums) {
        int size = nums.size();
        if (size < 4) return false;
        
        int sum = 0;
        for (auto& num : nums) sum += num;
        
        if (sum % 4 != 0) return false;
        vector<int> side(4);
        
        sort(nums.begin(), nums.end(), greater<int>());
        
        return dfs(nums, side, sum/4, 0);
    }
};