class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int res = 0;
        unordered_set<int> _set;
        
        for (int num : nums)
            _set.insert(num);
        
        for (int num : _set) {
            if (_set.find(num - 1) == _set.end()) {
                int currNum = num, curr = 1;
                
                while (_set.find(currNum + 1) != _set.end()) {
                    ++currNum;
                    ++curr;
                }
                
                res = max(curr, res);
            }
        }
        
        return res;
    }
};
