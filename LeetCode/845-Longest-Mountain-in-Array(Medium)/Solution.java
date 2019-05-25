class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        
        int max = 0, start = 0;
        
        while (start < A.length) {
            // uphill
            int end = start;
            while (end + 1 < A.length && A[end] < A[end + 1]) ++end;
            
            //downhill
            if (end != start && end + 1 < A.length && A[end] > A[end + 1]) {
                while(end + 1 < A.length && A[end] > A[end + 1])
                    ++end;
            
                max = Math.max(max, end - start + 1);
            }
            
            start = Math.max(start + 1, end);
        }
        
        return max;
    }
}