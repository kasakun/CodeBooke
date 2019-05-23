/**
 * 
 * dp[i][j] represents tha maximal square length which right corner is (i, j)
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int maxSquareLength = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
                }
            }
        }
            
        return maxSquareLength*maxSquareLength;
    }
}