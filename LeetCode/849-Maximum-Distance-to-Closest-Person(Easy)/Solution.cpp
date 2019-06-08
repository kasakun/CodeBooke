class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int size = seats.size();
        if (size <= 2) return 1;
        
        int prev = size, maxd = 0;
        
        for (int i = 0; i < size; ++i) {
            if (seats[i] == 1) {
                if (prev == size) maxd = max(maxd, i - 0);
                
                maxd = max(maxd, (prev == size) ? (i - 0) : (i - prev)/2);
                
                prev = i;
            }
        }
        
        if (seats[size - 1] == 0) maxd = max(maxd, size - 1 - prev);

        return maxd;
    }
};