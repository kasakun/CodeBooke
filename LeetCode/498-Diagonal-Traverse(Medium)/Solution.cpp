/**
 * Simple soluton 
 * 
 */
class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        if ((int)matrix.size() == 0|| (int)matrix[0].size() == 0)
            return res;
        int rows = matrix.size(), cols = matrix[0].size();
        int dr[] = {-1, 1}, dc[] = {1, -1};
        int i = 0, j = 0, n = 0, k = 0, size = rows*cols;

        while (n < size) {
            res.push_back(matrix[i][j]);

            int ni = i + dr[k%2], nj = j + dc[k%2];
            // hit the bondary, change the direction
            if (ni < 0 || ni >= rows || nj < 0 || nj >= cols) ++k;
            
            if (ni == -1 && nj < cols) ni = 0;
            if (nj == -1 && ni < rows) nj = 0;
            if (nj == cols) {ni = ni + 2;--nj;}
            if (ni == rows) {nj = nj + 2;--ni;}
            
            i = ni;
            j = nj;
            ++n;
        }
        
        return res;
    }
};