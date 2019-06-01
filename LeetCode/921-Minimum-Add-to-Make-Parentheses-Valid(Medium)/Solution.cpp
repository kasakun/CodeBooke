class Solution {
public:
    int minAddToMakeValid(string S) {
        int res = 0;
        stack<char> _stack;
        int size = S.size();
        for (int i = 0; i < size; ++i) {
            if (S[i] == '(')
                _stack.push(S[i]);
            if (S[i] == ')') {
                if (_stack.empty())
                    ++res;
                else 
                    _stack.pop();
            }
        }
        
        while (!_stack.empty()) {
            ++res;
            _stack.pop();
        }
        
        return res;
    }
};