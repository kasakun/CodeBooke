/**
 * The idea is to find a min first and then find a second min so far.
 *
 * The special case here is 1 2 0 3
 *
 * since at 3, min = 0, second min = 2, however we must make clear that if
 * second min is valid, means there must be a smaller one before second  min
 * which meets the requirement.
 */ 
class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int minNum = INT_MAX, secondMin = INT_MAX;

        for (auto& num : nums) {
            if (num <= minNum) minNum = num;
            else if (num <= secondMin) secondMin = num;
            else return true;
        }

        return false;
    }
};

