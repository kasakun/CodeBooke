/**
 * Quick Math Proof:
 * If a % b == 0, b % c ==0, then a % c == 0.
 * Proof: a = k*b, b = l*c, then a = k*l*c, both k and l are integer.
 *
 * The steps are:
 * 1. Sort
 * 2. Define dp[i] as longest length of subset based on pre i elements
 *    The update strategy is to look back all previous dp value to match
 *    mod condition. if it is, Max(dp[i], dp[j] + 1). Then the trick is
 *    if dp decrease by 1, then these elements are in one subset.
 * 3. Fix the max index
 * 4. As steo says, add all elements in subset to result.
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0 || nums == null) return new ArrayList<Integer>();
        
        int maxIndex = 0;
        int[] dp = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        
        // Sort
        Arrays.sort(nums);
        
        dp[0] = 1;
        
        // dp[i] - based on 0~i of nums, the longest length of subset 
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        
        // Find length of the longest subset
        for (int i = 1; i < nums.length; ++i)
            maxIndex = dp[maxIndex] > dp[i] ? maxIndex : i;
        
        // From the maxIndex back to index 0
        int prevNum = nums[maxIndex], currDp = dp[maxIndex];
        for (int i = maxIndex; i >= 0; --i) {
            if (prevNum % nums[i] == 0 && currDp == dp[i]) {
                res.add(nums[i]);
                prevNum = nums[i];
                --currDp;
            }
        }
        
        return res;
    }
}