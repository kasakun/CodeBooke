/**
 * Binary Search O(logn)
 */
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        
        int left = 0, right = citations.length - 1, n = citations.length;
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            int count = n - mid;
            int cita = citations[mid];
            
            if (count == cita) {
                return count;
            }
            else if (count < cita) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return n - (right + 1);
    }
}