/**
 * Binary search
 * Every time check how many numbers smaller than mid, if count < k, which means
 * mid is too small, find new mid in [mid + 1, end]
 *
 * Minor trick: why we put j = matrix[0].length - 1 out of the for loop?
 * Think of the situation:
 *  c  d
 *  a  b
 * we know d < b, if a num < d, then it must < b. 
 */
 class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int start = matrix[0][0], end = matrix[matrix.length - 1][matrix[0].length - 1];
        
        //[start, end]
        while (start <= end) {
            int count = 0, mid = start + (end - start)/2, j = matrix[0].length - 1;
            
            // check how many numbers smaller than mid
            for (int i = 0; i < matrix.length; ++i) {
                while (j >= 0 && matrix[i][j] > mid)
                    --j;
                
                count += (j + 1);
            }
            
            
            if (count < k) // mid is too small
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return start;
    }
}