class Solution {
public:
    string reverseWords(string s) {
        istringstream ss(s);
        
        string word, res;
        
        while (ss >> word) {
            reverse(word.begin(), word.end());
            
            res += word + " ";
        }
        
        res.pop_back();
        return res;
    }
};

