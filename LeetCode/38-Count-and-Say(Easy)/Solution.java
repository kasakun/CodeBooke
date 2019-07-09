class Solution {
public:
    string countAndSay(int n) {
        if (n == 1) return "1";
        
        string seq = countAndSay(n - 1);
        
        // size must larger than 1
        int size = seq.size(), i = 0;
        string res = "";

        while (i < size) {
            int count = 0;
            int  j = i;
            
            while (j < size && seq[i] == seq[j]) {
                ++count;
                ++j;
            }

            res += to_string(count);
            res += seq[i];
            
            i = j == i ? i + 1 : j;
        }
        
        return res;
    }
};

