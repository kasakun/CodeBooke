/**
 * 
 * Monoply stack
*/

class Solution {
public:
    int trap(vector<int>& height) {
        int ans = 0, curr = 0, size = height.size();
        if (size == 0) return 0;
        stack<int> _stack;
        
        while (curr < size) {
            // pop
            while (!_stack.empty() && height[curr] > height[_stack.top()]) {
                int bottom = _stack.top();
                _stack.pop();
                // must have a left to make a |_| structure
                if (_stack.empty()) break;
                
                int left = _stack.top(), right = curr;
                int width = right - left - 1;
                
                ans += (min(height[left], height[right]) - height[bottom])*width;
            }
            
            _stack.push(curr);
            ++curr;
        }
        
        return ans;
    }
};