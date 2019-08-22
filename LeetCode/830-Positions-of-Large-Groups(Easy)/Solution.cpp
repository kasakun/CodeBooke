class Solution {
public:
    vector<vector<int>> largeGroupPositions(string S) {
        vector<vector<int>> res;

        int i = 0, n = S.size();

        for (int j = 0; j < n; ++j) {
            if (j == n - 1 || S[j] != S[j + 1]) {
                if (j - i + 1 >= 3) res.push_back(vector<int>{i, j});
                i = j + 1;
            }

        }

        return res;

    }

};

