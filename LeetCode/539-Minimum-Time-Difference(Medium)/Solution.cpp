class Solution {
private:
    int computeMinutes(string time) {
        int hour = stoi(time.substr(0,2)), minute = stoi(time.substr(3, 5));
        
        return hour*60 + minute;
    }
    
    struct myCompare {
      bool operator() (int time1, int time2) {
          return time1 > time2;
      }  
    };
public:
    int findMinDifference(vector<string>& timePoints) {
        int size = timePoints.size();
        // the second condition is critical....16ms, without it 36ms
        if (size < 2 || size > 60*24) return 0;
        int minTimeDiff = INT_MAX;
        priority_queue<int, vector<int>, myCompare> pq;
        
        for (auto& time : timePoints) {
            int minutes = computeMinutes(time);
            
            pq.push(minutes);
            
            if (minutes < 720) pq.push(minutes + 1440);
        }
        
        int prev = pq.top();pq.pop();
        while (!pq.empty()) {
            int curr = pq.top();

            minTimeDiff = min(minTimeDiff, curr - prev);
            pq.pop();
            prev = curr;
        }
        
        return minTimeDiff;
    }
};