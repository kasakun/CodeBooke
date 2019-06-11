/**
 * The solution is tricky...
 * 
 * consider: abcd -> abcd, bcd, cd, d maxLength = 4
 *           abc  -> abc, bc, c       maxLength = 3
 *           ab   -> ab, b            maxLength = 2
 *           a    -> a                maxLength = 1
 * 
 * create int[26], each count the substring ends with corresponding char
 * 
 * d : 4, c : 3, b : 2, a: 1
 * 
 * sum up : 4 + 3 + 2 + 1 = 10
 * 
 * magic!
 *  
 */
class Solution {
public:
    int findSubstringInWraproundString(string p) {
        int size = p.size();
        int count[26] = {0};
        
        int maxLength = 0, res = 0;
        
        for (int i = 0; i < p.size(); ++i) {
            if (i > 0 && (p[i] - p[i - 1] == 1 ||
                          p[i - 1] - p[i] == 25))
                ++maxLength;
            else
                maxLength = 1;
            
            count[p[i] - 'a'] = max(maxLength, count[p[i] - 'a']);
        }
        
        for (int i = 0; i < 26; ++i)
            res += count[i];
        
        return res;
    }
};