/**
 * DFS
 **/
class Solution {
public:
    vector<pair<int, int>> pacificAtlantic(vector<vector<int>>& matrix) {
        vector<pair<int, int>> res;
        int rows = matrix.size();
        if (rows == 0)
            return res;
        int cols = matrix[0].size();
        if (cols == 0)
            return res;
        vector<vector<bool>> pacific(rows, vector<bool>(cols));
        vector<vector<bool>> atlantic(rows, vector<bool>(cols));
        
        for (int i = 0; i < rows; i++) {
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic, i, cols-1);

        }
        for (int j = 0; j < cols; j++) {
            dfs(matrix, pacific, 0, j);
            dfs(matrix, atlantic, rows-1, j);
        }

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.push_back(make_pair(i,j));
            }
        }
        return res;
    }
    
    void dfs(vector<vector<int>>& matrix, vector<vector<bool>>& visited, int i, int j) {
        int rows = matrix.size();
        int cols = matrix[0].size();

        visited[i][j] = true;
        //up
        if (i-1 >= 0 && visited[i-1][j] != true && matrix[i-1][j]>=matrix[i][j])
            dfs(matrix, visited, i-1, j);
        //down
        if (i+1 < rows && visited[i+1][j] != true && matrix[i+1][j]>=matrix[i][j])
            dfs(matrix, visited, i+1, j);
        //left
        if (j-1 >= 0 && visited[i][j-1] != true && matrix[i][j-1]>=matrix[i][j])
            dfs(matrix, visited, i, j-1);
        //right
        if (j+1 <cols && visited[i][j+1] != true && matrix[i][j+1]>=matrix[i][j])
            dfs(matrix, visited, i, j+1);

    }
};

