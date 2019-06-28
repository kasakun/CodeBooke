class Solution {
private:
    unordered_set<int> visited;
    vector<vector<int>> res;
    vector<int> seq;
    
    void dfs(vector<int>& nums) {
        if (seq.size() == nums.size()) {
            res.push_back(vector<int>(seq));
        }
        
        for (int i = 0; i < nums.size(); ++i) {
            if (visited.count(nums[i])) continue;
            visited.insert(nums[i]);
            seq.push_back(nums[i]);
            dfs(nums);
            visited.erase(nums[i]);
            seq.erase(seq.end() - 1);
        }
    }

public:
    vector<vector<int>> permute(vector<int>& nums) {
        
        dfs(nums);
        
        return res;
    }
};

