class Solution {
private:
    static bool cmp(vector<int> x, vector<int> y) {
        return x[0] < y[0];
    }
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        if (intervals.size() == 0) return 0;
        int res = 1;
        priority_queue<int, vector<int>, greater<int>> pq;

        sort(intervals.begin(), intervals.end(), cmp);
        pq.push(intervals[0][1]);

        for (int i = 1; i < intervals.size(); ++i) {
            // pop out the interval which has smallest end
            if (pq.top() <= intervals[i][0]) pq.pop();
            pq.push(intervals[i][1]);
            res = max(res, (int)pq.size());
        }

        return res;
    }
};
