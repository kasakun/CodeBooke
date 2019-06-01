/**
 * simple solution not O(1) space 
 */
class Solution {
public:
    bool backspaceCompare(string S, string T) {
        stack<char> s1, s2;
        
        for (auto& c : S) {
            if (c == '#') {
                if (!s1.empty())
                    s1.pop();
                continue;
            }
            s1.push(c);
        }
        
        for (auto& c : T) {
            if (c == '#') {
                if (!s2.empty())
                    s2.pop();
                continue;
            }
            s2.push(c);
        }
        
        while(!s1.empty() && !s2.empty() && s1.top() == s2.top()) {
            s1.pop();s2.pop();
        }
        
        return s1.empty() && s2.empty();
    }
};