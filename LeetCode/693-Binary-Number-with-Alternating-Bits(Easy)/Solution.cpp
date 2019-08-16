class Solution {
public:
    bool hasAlternatingBits(int n) {
        int mask = 0x1;
        int buf = mask & n;

        while (n != 0) {
            n = n >> 1;
            if ((buf ^ (mask & n) != 0x1))
                return false;
            buf = mask & n;
            n >> 1;
        }
        return true;
    }

};

