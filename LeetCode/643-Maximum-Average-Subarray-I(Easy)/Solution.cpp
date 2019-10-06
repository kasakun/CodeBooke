class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int count = 0, sum = 0, _max = INT_MIN;

        for (int i = 0; i < nums.size(); ++i) {
            if (count < k) {
                ++count;
                sum += nums[i];
                _max = sum;
            } else {
                sum -= nums[i - k];
                sum += nums[i];
                _max = max(_max, sum);
            }
        }

        return _max*1.0/k;
    }
};

