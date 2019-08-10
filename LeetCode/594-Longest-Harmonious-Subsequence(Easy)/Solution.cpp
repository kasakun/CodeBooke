class Solution {
public:
    int findLHS(vector<int>& nums) {
        int res = 0;
        unordered_map<int, int> _map;
        
        for (auto num : nums) ++_map[nums];

        for (auto it : _map)
            if (_map.count(it.first - 1) > 0)
                res = max(res, it.second + _map[it.first - 1]);
        return res;
    }
};

