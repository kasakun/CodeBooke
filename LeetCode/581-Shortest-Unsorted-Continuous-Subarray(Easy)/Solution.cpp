class Solution{
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int left = nums.size(), right = 0;
        stack<int> s1, s2;

        for (int i = 0; i < nums.size(); ++i) {
            while (!s1.empty() && nums[s1.top()] > nums[i]) {
                left = min(left, s1.top()); s1.pop();
            }
            s1.push(i);
        }

        for (int i = nums.size() - 1; i >= 0; --i) {
            while (!s2.empty() && nums[s2.top()] < nums[i]) {
                left = min(left, s2.top()); s2.pop();
            }
            s2.push(i);
        }

        return right - left > 0 ? right - left + 1 : 0;
    }
};

