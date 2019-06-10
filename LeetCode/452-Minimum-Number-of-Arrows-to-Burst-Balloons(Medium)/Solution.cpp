/**
 * Similar to 435
 */
class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        int size = points.size();
        if (size == 0) return 0;
        
        int minEnd = INT_MAX, count = 1;
        sort(points.begin(), points.end());
        
        for (auto& point : points) {
            //hit the overlapped area
            if (point[0] <= minEnd) {
                minEnd = min(point[1], minEnd);
            }
            else {
                ++count;
                minEnd = point[1];
            }
        }
        
        return count;
    }
};