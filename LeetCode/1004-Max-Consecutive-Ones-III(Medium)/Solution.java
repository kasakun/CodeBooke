class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, oneCount = 0, zeroCount = 0, max = 0;
        
        for (; right < A.length; ++right) {
            if (A[right] == 1) ++oneCount;
            
            zeroCount = right - left + 1 - oneCount;
            
            if (zeroCount > K) {
                if (A[left] == 0)
                    --zeroCount;
                else
                    --oneCount;
                ++left;
            } else {
                max = Math.max(max, right - left + 1);
            }
        }
        
        return max;
    }
}