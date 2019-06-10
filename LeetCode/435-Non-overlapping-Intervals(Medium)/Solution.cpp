class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        int size = intervals.size();
        if (size == 0) return 0;
        // count total overlaps
        // intervals have overlaps means they have a continuous shared area
        // [1, 10], [2, 5], [6, 7] -> 2 overlaps
        // because 2 shared area
        int count = 1, minEnd = INT_MAX;
        sort(intervals.begin(), intervals.end());
        
        for (auto& interval : intervals) {
            if (interval[0] >= minEnd) {
                minEnd = interval[1];
                ++count;
            } else {
                minEnd = min(minEnd, interval[1]);
            }
        }
        
        return size - count;
    }
};