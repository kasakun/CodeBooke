class Solution {
public:
    vector<int> partitionLabels(string S) {
        int lastIndex[26] = {0};
        vector<int> res;
        
        for (int i = 0; i < S.size(); ++i)
            lastIndex[S[i] - 'a'] = i;
        
        int left = 0, right = 0;
        
        for (int i = 0; i < S.size(); ++i) {
            // get the right bound for current char
            right = max(right, lastIndex[S[i] - 'a']);
            
            // hit
            if (i == right) {
                res.push_back(right - left + 1);
                left = right + 1;
            }
        }
        
        return res;
    }
};