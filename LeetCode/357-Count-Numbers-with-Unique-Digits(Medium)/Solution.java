/**
 * f(1) = 10
 * f(2) = 9*9
 * f(3) = 9*9*8
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n >= 10) return -1;
        
        int res = 10, base = 9;
        
        for (int i = 2; i <= n && i <= 10; ++i) {
            base *= (9 - i + 2);
            res += base;
        }
        
        return res;
    }
}