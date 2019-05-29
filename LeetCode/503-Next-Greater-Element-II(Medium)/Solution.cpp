/**
 * The idea is to use stack to store the next greater element
 * The top is the the next greater element
 * 
 * iterate twice
 */
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> res(nums.size());
        stack<int> _stack;
        
        for (int i = 2*nums.size() - 1; i >= 0; --i) {
            while (!_stack.empty() && nums[_stack.top()] <= nums[i%nums.size()])
                _stack.pop();
            
            res[i%nums.size()] = _stack.empty() ? -1 : nums[_stack.top()];
            _stack.push(i%nums.size());
        }
        
        return res;
    }
};