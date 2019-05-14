/**
 * The way to modify the nums[] is to overwrite the value,
 * there is no need to modify the length of nums since you return the length
 * of new array.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int n: nums) {
            // only insert when duplicates < 2
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        }

        return i;
    }
}