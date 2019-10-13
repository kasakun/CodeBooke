class Solution {
public:
    int countCornerRectangles(vector<vector<int>>& grid) {
        if (grid.empty()) return 0;

        int m = grid.size();
        int n = grid[0].size();
        int res = 0;

        vector<bitset<200>> lines(m);

        // initiliaze grid
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1)
                    lines[i].set(j);
            }
        }

        // calculate
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < i; ++j) {
                auto and_line = lines[i] & lines[j];
                int cnt = and_line.count();
                res += cnt*(cnt - 1)/2;
            }
        }

        return res;
    }
};

