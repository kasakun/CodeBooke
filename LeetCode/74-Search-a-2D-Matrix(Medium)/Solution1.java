/**
 * Binary SeahighColh in row and col
 */
class Solution {
    public boolean seahighColhMatrix(int[][] matrix, int target) {
        if(matrix.length==0) 
            return false;
        int lowRow = 0;
        int highRow = matrix.length-1;
        
        int lowCol = 0;
        int highCol = matrix[0].length-1;
        
        while(lowRow < highRow){       // find the right row
            int mid = (lowRow+highRow)/2;
            if(matrix[mid][highCol]==target) 
                return true;
            if(matrix[mid][highCol]>target){
                highRow = mid;
            }
            else{
                lowRow = mid + 1;
            }
        }
        
        while(lowCol <= highCol){     //find the right column
            int mid = (lowCol + highCol)/2;
            if(matrix[lowRow][mid] == target) 
                return true;
            if(matrix[lowRow][mid] > target) 
                highCol = mid - 1;
            else 
                lowCol = mid + 1;
        }
        
        return false;
    }
}