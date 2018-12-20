/**
 * Consider it as a 1D array.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) 
            return false;
         if(matrix[0].length == 0) 
            return false;
        
        int low = 0, high = matrix.length*matrix[0].length - 1;
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            
            int i = mid/matrix[0].length, j = mid%matrix[0].length;
            
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return false;
        
    }
}