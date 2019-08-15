class Solution {
public:
    int monotoneIncreasingDigits(int N) {
        string s = to_string(N);

        int i = 1;

        while (i < s.size() && s[i - 1] <= s[i]) ++i;
        while (i > 0 && i < s.size() && s[i - 1] > s[i]) {
            --i;
            --s[i];
        }

        for (int j = i + 1; j < s.size(); ++j)
            s[j] = '9';

        return stoi(s);
    }
};

