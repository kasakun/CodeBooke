/**
 * Use simulation
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List res = new ArrayList<>();
        if (matrix.length == 0) return res;
        
        int rowNumber = matrix.length, colNumber = matrix[0].length;
        boolean[][] seen = new boolean[rowNumber][colNumber];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int row = 0, col = 0, di = 0;
        
        for (int i = 0; i < rowNumber*colNumber; ++i) {
            res.add(matrix[row][col]);
            seen[row][col] = true;
            
            // check if is legal
            int nextRow = row + dr[di];
            int nextCol = col + dc[di];
            
            // seen[][] must be the last to avoid out of bound
            if (0 <= nextRow && nextRow < rowNumber &&
                0 <= nextCol && nextCol < colNumber &&
                !seen[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            } else {
                di = (di + 1)%4;
                row += dr[di];
                col += dc[di];
            }
        }
        
        return res;
    }
}