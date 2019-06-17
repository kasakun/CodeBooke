/**
 * O(N)
 */ 
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> dq;
        vector<int> res;
        
        for (int i = 0; i < nums.size(); ++i) {
            // check the coming one is the max or the second max
            while (!dq.empty() && nums[dq.back()] <= nums[i])
                dq.pop_back();
            
            dq.push_back(i);
            
            // check the curr max is out of window 
            if (dq.front() <= i - k) dq.pop_front();
            
            if (i >= k - 1) res.push_back(nums[dq.front()]);
        }
        
        return res;
    }
};

