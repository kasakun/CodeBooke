class Solution {
public:
    int longestPalindrome(string s) {
        vector<int> count(256, 0);
        
        for (auto& c : s)
            ++count[c-'\0'];

        int res = 0;
        for (auto& i : count) {
            res += i / 2 * 2;
            
            if (res % 2 == 0 && i % 2 == 1)
                ++res;
        }
        
        return res;
    }
};

