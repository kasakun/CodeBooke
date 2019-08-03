class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        int m = 0;
        unordered_map<int, int> count;
        
        for (int i = 0; i < wall.size(); ++i) {
            int sum = 0;
            for (int j = 0; j < wall[i].size() - 1; ++j) {
                sum += wall[i][j];
                ++count[sum];
            }
        }
        
        for (auto it = count.begin(); it != count.end(); ++it)
            m = max(m, it->second);
        
        return wall.size() - m;
    }
};

