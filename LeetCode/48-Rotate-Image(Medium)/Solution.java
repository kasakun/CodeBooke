class Solution {
    public void rotate(int[][] matrix) {
        for (int  i = 0; i < matrix.length; ++i) {
            for (int j = i; j < matrix[0].length; ++j) {
                if (i == j) continue;
                
                int temp;
                
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < matrix.length; ++i) {
            int axis = matrix[0].length >>> 1;
            for (int j = 0; j < axis; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }
        
        return;
    }
}