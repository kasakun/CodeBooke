class Solution {
public:
    int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        if (n == 2) return k*k;

        int same = k*1, diff = k*(k - 1);

        // start at 2 because
        // at 0, k
        // at 1, k*k
        for (int i = 2; i < n; ++i) {
            int lastSame = same;

            same = diff;
            diff = (lastSame + diff)*(k - 1);
        }

        return same + diff;
    }
};

