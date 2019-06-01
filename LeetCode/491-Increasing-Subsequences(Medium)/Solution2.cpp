class Solution {
private:
    void dfs(vector<int>& nums, vector<vector<int>>& res, vector<int>& seq, int start) {
        if (seq.size() > 1) res.push_back(seq);
        unordered_set<int> _set;
        
        for (int i = start; i < nums.size(); ++i) {
            if (_set.find(nums[i]) != _set.end()) continue;
            if (seq.empty() || nums[i] >= seq.back()) {
                seq.push_back(nums[i]);
                dfs(nums, res, seq, i + 1);
                seq.pop_back();
                _set.insert(nums[i]);
            }
        }
        
        return;
    }
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        vector<int> seq;
        vector<vector<int>> res;
        
        dfs(nums, res, seq, 0);
        
        return res;
    }
};