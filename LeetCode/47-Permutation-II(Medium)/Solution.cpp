class Solution {
private:
    vector<int> seq;
    vector<vector<int>> res;
    unordered_set<int> visited;

    void dfs(vector<int>& nums) {
        if (seq.size() == nums.size()) {
            res.push_back(vector<int>(seq));
            return;
        }
        
        int prev;
        unordered_set<int> used;
        for (int i = 0; i < nums.size(); ++i) {
            if (visited.count(i) || used.count(nums[i])) continue;
            seq.push_back(nums[i]);
            visited.insert(i);
            used.insert(nums[i]);
            dfs(nums);
            seq.erase(seq.end() - 1);
            visited.erase(i);
        }
    }

public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        
        dfs(nums);

        return res;
    }
};

