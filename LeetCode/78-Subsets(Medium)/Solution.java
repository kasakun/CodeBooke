/**
 * Use dfs to realize combination.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        
        for (int i = 0; i <= nums.length; ++i) {
            combination(res, comb, nums, 0, i);
        }
        
        return res;
    }
    
    /**
     * 
     * @param res
     * @param comb
     * @param nums
     * @param start plus each time
     * @param k     k of (n, k)
     */
    private void combination(List<List<Integer>> res, 
                             List<Integer> comb, 
                             int[] nums, 
                             int start, 
                             int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        
        for (int i = start; i < nums.length && k > 0; ++i) {
            comb.add(nums[i]);
            combination(res, comb, nums, i + 1, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}