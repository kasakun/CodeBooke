/**
 * Boyer-Moore Vote
 */
class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                ++count;
                major = num;
            } else if (major == num)
                ++count;
            else
                --count;
        }
        
        return major;
    }
}