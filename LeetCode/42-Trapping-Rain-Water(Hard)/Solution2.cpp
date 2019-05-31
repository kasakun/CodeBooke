/** 
 * Use to vector to record the left max and right max
 */

class Solution {
public:
    int trap(vector<int>& height) {
        int size = height.size();
        if (size == 0) return 0;
        int ans = 0;
        vector<int> left_max(size), right_max(size);
        
        left_max[0] = height[0];right_max[size - 1] = height[size - 1];
        
        for (int i = 1; i < size; ++i) {
            left_max[i] = max(left_max[i - 1], height[i]);
            right_max[size - i - 1] = max(right_max[size - i], height[size - i - 1]);
        }
        
        for (int i = 1; i < size - 1; ++i)
            ans += min(left_max[i], right_max[i]) - height[i];
        
        
        return ans;
    }
};