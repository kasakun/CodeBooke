class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> dict(128, 0);
        
        for (char c : t) ++dict[c];
        
        int left = 0, right = 0, start = 0, len = INT_MAX, n = t.size();
        
        while (right < s.size()) {
            --dict[s[right]];
            if (dict[s[right]] >= 0) --n;
            ++right;
            
            while (n == 0) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                
                //move left
                ++dict[s[left]];
                if (dict[s[left]] > 0) ++n;
                ++left;
            }
            
        }
        cout << len;
        return len < INT_MAX ? s.substr(start, len) : "";
    }
};

