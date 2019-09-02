// Forward declaration of the knows API.
bool knows(int a, int b);

class Solution {
public:
    int findCelebrity(int n) {
        int res = 0;

        // Find a potential candidate does not know any one
        for (int i = 1; i < n ; ++i) {
            if (!knows(i, res)) res = i;
        }

        for (int i = 0; i < n; ++i) {
            if (i == res) continue;

            if (!knows(i, res) || knows(res, i)) return -1;
        }

        return res;
    }
};

