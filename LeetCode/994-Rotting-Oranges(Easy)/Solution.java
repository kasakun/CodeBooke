/**
 * BFS
 */
class Solution {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    
    public int orangesRotting(int[][] grid) {
        int rowNumber = grid.length, colNumber = grid[0].length, res = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> time = new HashMap<>();
        
        //scan
        
        for (int i = 0; i < rowNumber; ++i) {
            for (int j = 0; j < colNumber; ++j) {
                if (grid[i][j] == 2) {
                    int node = i*colNumber + j;
                    queue.add(node);
                    time.put(node, 0);
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.remove();
            
            int i = node / colNumber, j = node % colNumber;
            
            for (int k = 0; k < 4; ++k) {
                int newi = i + dr[k], newj = j + dc[k];
                
                if (0 <= newi && newi < rowNumber &&
                    0 <= newj && newj < colNumber &&
                    grid[newi][newj] == 1) {
                    
                    grid[newi][newj] = 2;
                    int newNode = newi*colNumber + newj;
                    queue.add(newNode);
                    time.put(newNode, time.get(node) + 1);
                    res = time.get(newNode);
                }
            }
        }
        
        // fresh remain
        for (int[] row : grid) {
            for (int orange : row) {
                if (orange == 1) return -1;
            }
        }
        
        return res;
    }
}