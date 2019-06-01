/**
 * Naive solution. TLE 
 */

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int size = heights.size();
        int res = 0;
        
        if (size == 0) return res;
        
        for (int i = 0; i < size; ++i) {
            int min_height = heights[i];
            for (int j = i; j < size; ++j) {
                int distance = j - i + 1;
                min_height = min(min_height, heights[j]);
                res = max(distance*min_height, res);
            }
        }
        
        return res;
    }
};