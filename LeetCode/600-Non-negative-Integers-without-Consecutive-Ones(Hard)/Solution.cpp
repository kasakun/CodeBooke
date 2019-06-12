/**
 * This is really tricky, I dont think it is necessary to prepare for the interview
 * 
 * Let's take: 1010110 as example. we can split it to 0 - 0111111 and 1000000-1010110
 * 
 * 0-0111111 can be treated as dp[6] can be splitted to 0-0011111 dp[5] and
 * 0-0101111 (which equals 0-0001111 dp[4])
 * 
 * so we have dp[i] = dp[i - 1] + dp [i - 2]. dp[i] represnets res in 0-1...1 (k ones) range
 * 
 * and done with that part, we can go right to do the same check but if there is consecutive
 * there is no need. consider the example is 1100110, the second part is 100000-1100110
 * and once we finish 1000000-1100110, there is no need to do 1100000-1100110 since we
 * must have consecutive ones(what line 30-34 does)
 * 
 */
class Solution {
public:
    int findIntegers(int num) {
        int dp[32] = {0};
        
        dp[0] = 1; // 
        dp[1] = 2; // 0 and 1
        
        for (int i = 2; i < 32; ++i)
            dp[i] = dp[i - 1] + dp[i - 2];
        
        int res = 0, k = 30, pre_bit = 0;
        while (k >= 0) {
            if (num&(1 << k)) {
                res += dp[k];
                // no need to continue because of consecutive
                if (pre_bit) return res;
                pre_bit = 1;
            }
            else
                pre_bit = 0;
            --k;
        }
        return res + 1;
    }
};