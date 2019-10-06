class Solution {
public:
    int maxDistance(vector<vector<int>>& arrays) {
        int res = 0;
        int _min = arrays[0][0];;
        int _max = arrays[0][arrays[0].size() - 1];

        for (int i = 1; i < arrays.size(); ++i) {
            res = max(res, max(abs(arrays[i][arrays[i].size() - 1] - _min), abs(_max - arrays[i][0])));
            _min = min(_min, arrays[i][0]);
            _max = max(_max, arrays[i][arrays[i].size() - 1]);
        }

        return res;
    }
};

