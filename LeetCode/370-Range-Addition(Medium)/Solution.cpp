class Solution {
public:
    vector<int> getModifiedArray(int length, vector<vector<int>>& updates) {
        vector<int> res(length, 0);

        for (auto& update : updates) {
            int start = update[0], end = update[1], val = update[2];

            res[start] += val;

            if (end < length - 1)
                res[end + 1] -= val;
        }
        // partial_sum(x[0], x[n], y[0])
        // y[n] = y[n - 1] + x[n]
        partial_sum(res.begin(), res.end(), res.begin());

        return res;
    }
};

