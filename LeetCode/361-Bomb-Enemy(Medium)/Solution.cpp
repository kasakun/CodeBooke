class Solution {
public:
    int maxKilledEnemies(vector<vector<char>>& grid) {
        if (grid.size() == 0 || grid[0].size() == 0)
            return 0;
        int row = grid.size();
        int col = grid[0].size();
        int res = 0;
        vector<vector<int>> count(row, vector<int>(col, 0));

        // row
        for (int i = 0; i < row; ++i) {
            int head = 0, tail = 0;
            for (int j = 0; j < col; ++j) {
                // First,add to the count
                // Then count the curr enemies for the
                // next bucket
                // The trick is we traverse from both ends in one loop
                count[i][j] = grid[i][j] != '0'? 0 : (count[i][j] + head);
                count[i][col - 1 - j] = grid[i][col - 1- j] != '0'?
                    0 : (count[i][col - 1- j] + tail);

                head = grid[i][j] == 'W' ? 0 : (head + (grid[i][j] == 'E' ? 1 : 0));
                tail = grid[i][col - 1- j] == 'W' ?
                    0 : (tail + (grid[i][col - 1 - j] == 'E' ? 1 : 0));
            }
        }

        // col
        for (int j = 0; j < col; ++j) {
            int head = 0, tail = 0;
            for (int i = 0; i < row; ++i) {
                // First,add to the count
                // Then count the curr enemies for the
                // next bucket
                // The trick is we traverse from both ends in one loop
                count[i][j] = grid[i][j] != '0'? 0 : (count[i][j] + head);
                count[row - 1 - i][j] = grid[row - 1- i][j] != '0'?
                    0 : (count[row - 1 - i][j] + tail);

                head = grid[i][j] == 'W' ? 0 : (head + (grid[i][j] == 'E' ? 1 : 0));
                tail = grid[row - 1- i][j] == 'W' ?
                    0 : (tail + (grid[row - 1- i][j] == 'E' ? 1 : 0));
            }
        }

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                res = max(res, count[i][j]);

        return res;
    }
};

