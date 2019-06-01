/**
 * Monoply stack
 * The idea is push higher h into stack, once a lower h occurs, we go continuing
 * go back to the much lower one in stack
 * The key point is to deal with the left bound.
 * 
 * special case:
 *  stack is empty: means all left must be higher or curr_pos is 0
 */
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int size = heights.size();
        if (size == 0) return 0;
        
        int res = 0, i = 0;
        stack<int> _stack;
        
        while (i <= size) {
            int height = i == size ? 0 : heights[i];
            if (_stack.empty() || height >= heights[_stack.top()]) {
                _stack.push(i);
                ++i;
            }
            else {
                // i is fixed.
                int right_highest = heights[_stack.top()];
                _stack.pop();
                int j = _stack.empty() ? 0 : _stack.top() + 1;
                res = max(res, (i - j)*right_highest);
            }
        }
        
        return res;
    }
};