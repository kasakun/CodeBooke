/**
 * O(1) space
 */
class Solution {
public:
    bool backspaceCompare(string S, string T) {
        int i = S.size() - 1, j = T.size() - 1;
        int backspace_s = 0, backspace_t = 0;
        
        while(i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S[i] == '#') {++backspace_s; --i;}
                else if (backspace_s > 0) {--backspace_s; --i;}
                else break;
            }
            
            while (j >= 0) {
                if (T[j] == '#') {++backspace_t; --j;}
                else if (backspace_t > 0) {--backspace_t; --j;}
                else break;
            }
            
            if (i >= 0 && j >= 0 && S[i] != T[j]) return false;
            
            if ((i >= 0) != (j >= 0)) return false;
            
            --i;--j;
        }
        
        return true;
    }
};