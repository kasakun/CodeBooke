class Solution {
    private int[] dr = new int[]{-1, 0, 1, 0};
    private int[] dc = new int[]{0, -1, 0, 1};
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return  0;
        
        int count = 0;
        int MOD = 1000000007;
        int[][][] dp = new int[m][n][N + 1]; // n moves, ways to dp[i][j]
        
        dp[i][j][0] = 1;
        
        for (int step = 1; step < N + 1; ++step) {
            
            for (int k = 0; k < m; ++k) {
                for (int l = 0; l < n; ++l) {
                    for (int d = 0; d < 4; ++d) {
                        int newk = k + dr[d], newl = l + dc[d];
                        
                        if (newk < 0 || newk >= m || newl < 0 || newl >= n) 
                            count = (count + dp[k][l][step - 1])%MOD;
                        else
                            dp[newk][newl][step] = (dp[newk][newl][step] + dp[k][l][step - 1])%MOD;
                    }
                }
            }
        }
        
        return count;
    }
}