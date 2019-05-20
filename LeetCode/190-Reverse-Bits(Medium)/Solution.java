public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        
        for (int i = 0; i < 32; ++i) {
            res += 1 & n;       
            
            if (i < 31) res = res << 1;
            n = n >> 1;
        }
        
        return res;
    }
}