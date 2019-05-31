class Solution {
private:
    void dfs(vector<int>& candidates, vector<vector<int>>& res, vector<int>& list, int start, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.push_back(list);
            return;
        }
        
        for (int  i = start; i < candidates.size(); ++i) {
            list.push_back(candidates[i]);
            dfs(candidates, res, list, i, target - candidates[i]);
            list.erase(list.end() - 1);
        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> list;
        vector<vector<int>> res;
        
        dfs(candidates, res, list, 0, target);
        
        return res;
    }
};