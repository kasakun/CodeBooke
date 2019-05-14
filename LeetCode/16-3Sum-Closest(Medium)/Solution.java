/**
 * Similar to 3Sum
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int minDistance = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int distance = Math.abs(target -sum);
                
                if (sum == target) {
                    return sum;
                }
                
                if (distance < minDistance) {
                    closestSum = sum;
                    minDistance = distance;
                }
                
                //approaching
                if (sum > target) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        
        return closestSum;
    }
}