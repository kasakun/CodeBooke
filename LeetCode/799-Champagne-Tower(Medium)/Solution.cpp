/**
 * Simulation 
 * 
 */
class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        double tower[query_row + 1][query_row + 1];
        memset(tower, 0, sizeof(tower));
        
        tower[0][0] = poured;
        
        for (int i = 1; i <= query_row; ++i) {
            for (int j = 0; j <= i; ++j) {
                if(tower[i - 1][j] > 1)
                    tower[i][j] += (tower[i - 1][j] - 1)/2;
                
                if(j >= 1 && tower[i - 1][j - 1] > 1)
                    tower[i][j] += (tower[i - 1][j - 1] - 1)/2;
            }
        }
        
        return min(1.0, tower[query_row][query_glass]);
    }
};