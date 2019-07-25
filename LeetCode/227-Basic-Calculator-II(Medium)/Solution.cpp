class Solution {
public:
    int calculate(string s) {
        istringstream ss('+' + s + '+');
        
        long long res = 0, term = 0, n;
        
        char op;
        
        while (ss >> op) {
            if (op == '+' || op == '-') {
                res += term;
                
                ss >> term;
                
                term = op == '+' ? term : (-term);
            } else {
                ss >> n;
                
                if (op == '*')
                    term *= n;
                else
                    term /= n;
            }
        }
        
        return res;
    }
};

