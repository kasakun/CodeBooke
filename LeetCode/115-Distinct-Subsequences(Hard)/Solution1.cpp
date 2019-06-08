/**
 * TLE Bad Solution
 * /
class Solution {
private:
    int dfs(string& s, string& target, string seq, int si, int ti) {
        // cout << seq << " ";
        if (target == seq) return 1;
        if (ti == target.size()) return 0;
        
        int count = 0;
        
        for (int i = si; i < s.size(); ++i) {
            if (s[i] == target[ti])
                count += dfs(s, target, seq + s[i], i + 1, ti + 1);
        }
        
        return count;
    }
public:
    int numDistinct(string s, string t) {
        return dfs(s, t, "", 0, 0);
    }
};