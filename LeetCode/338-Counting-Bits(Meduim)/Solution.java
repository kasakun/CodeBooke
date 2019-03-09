/*
 *    0
 *    1
 *   10
 *   11
 *  100
 *  101
 *  110
 *  111
 * 1000
 * 1001
 * 1010
 * 
 * dp[i] = dp[i - offset] + 1
 *
 **/


class Solution {
    public int[] countBits(int num) {
        int res[] = new int[num + 1];
        int offset = 1;
        for (int i = 1; i < num + 1; ++i) {
            if (offset * 2 == i) offset *= 2;
            res[i] = res[i - offset] + 1;
        }
        return res;
    }
}