/**
 * curr represents tha max value so far
 * why `-1`? since we need j - i
 * we can gradually minus 1 
 * 
 */
class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& A) {
        int curr = 0, res = 0;
        
        for (int& a : A) {
            res = max(res, curr + a);
            curr = max(curr, a) - 1;
        }
  
        return res;
    }
};