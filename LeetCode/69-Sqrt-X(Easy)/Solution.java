/**
 * binary search
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        
        int start = 1, end = x, res = 0;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid > x/mid) {
                end = mid - 1;
            } else {
                if ((mid + 1) > x/(mid + 1)) {
                    res = mid;
                    break;
                }
                
                start = mid + 1;
            }
        }
        
        return res;
    }
}