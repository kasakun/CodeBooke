class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        int size1 = nums1.size(), size2 = nums2.size();
        if (size1 == 0 || size2 == 0) return res;
        
        unordered_set<int> _set;
        
        for (auto& num : nums1) {
            if (_set.count(num))
                continue;
            _set.insert(num);
        }
        
        for (auto& num : nums2) {
            if (_set.count(num)) {
                _set.erase(num);
                res.push_back(num);
            }
        }
        
        return res;
    }
};

