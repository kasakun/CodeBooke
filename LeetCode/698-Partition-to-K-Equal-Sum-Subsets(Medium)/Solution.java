/**
 * The trick is if we have k sets and a target number, which is the average number.
 *
 * However we put the numbers in these sets, if one set exceeds average, it means
 * at least one other set must be less than the average. Thus, if none of sets
 * exceeds average, which implicitly indicates we are all set. - They are all
 * target numbers!
 */
class Solution {
    int[] mark;
    private boolean findSubsets(int[] nums, int target, int[] sets, int index) {
        if (index < 0) return true;
        
        int value = nums[index];
        
        for (int setIndex = 0; setIndex < sets.length; ++setIndex) {
            if (sets[setIndex] + value <= target) {
                sets[setIndex] += value;
                
                if (findSubsets(nums, target, sets, index - 1)) return true;

                sets[setIndex] -= value;
            }
            /**
             * The reason is if this set is removed to 0, the number it used must
             * not fit the other set too. Set-with-Set is equivalent.
             */
            if (sets[setIndex] == 0) break;
        }
        
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 0) return true;
        
        int  sum = 0;
        
        for (int num : nums) sum += num;

        if (sum % k != 0) return false;
        
        int target = sum/k;
        
        // must match k - 1 times
        Arrays.sort(nums);
        int index = nums.length - 1;
        if (sum < nums[index]) return false;
        
        while (index >= 0 && nums[index] == sum) {
            --index;
            --k;
        }
        
        return findSubsets(nums, target, new int[k], index);
    }
}