/**
 * DP 200+ms
 * 
 * but it is not a good solution, since we cannot avoid using 
 * ordered map or self defined hash for unoredered map, both require
 * high time consumption. The idea is really simple.
 * 
 */
class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        vector<vector<int>> res;
        if (nums.empty() || nums.size() < 2) return res;
        
        vector<vector<vector<int>>> dp;
        set<vector<int>> _set;
        int size = nums.size();
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] <= nums[i]) {
                    dp[i].push_back({nums[j], nums[i]});
                    if (_set.find({nums[j], nums[i]}) == _set.end()) {
                        _set.insert({nums[j], nums[i]});
                        res.push_back({nums[j], nums[i]});
                    }
                    
                    //append it to all sub in dp[j]
                    for (auto list : dp[j]) {
                        list.push_back(nums[i]);
                        dp[i].push_back(list);
                        if (_set.find(list) == _set.end()) {
                            _set.insert(list);
                            res.push_back(list);
                        }
                    }
                }
            }
        }
        
        return res;
    }
};