/**
 * O(NlogN)
 */
class Solution2 {
    private int BS(int start, int end, int key, int[] sums) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (key <= sums[mid]) {
                end -= 1;
            } else {
                start += 1;
            }
        }
        
        return start;
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int min = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        
        for (int i = 1; i < sums.length; ++i) sums[i] = sums[i - 1] + nums[i - 1];
        
        for (int i = 0; i < sums.length; ++i) {
            int end = BS(i + 1, sums.length - 1, sums[i] + s, sums);
            
            if (end == sums.length) break; // loops after it is unnecessary
            
            min = Math.min(min, end - i);
        }

        return min == Integer.MAX_VALUE? 0 : min;
    }
}