/**
 * Backtracking.
 * 
 * ex:
 * n = 4, k = 2.
 * 

import com.sun.org.glassfish.gmbal.ParameterNames;
 * 1, 2; 1, 3; 1, 4
 * 2, 3; 2, 4
 * 3, 4
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = i + 1;
        }
        
        dfs(res, new ArrayList<Integer>(), nums, 0, k);
        return res;
    }
    
    /**
     * 
     * @param final result
     * @param comb k==0, final comb;otherwise it is temp path
     * @param start index
     * @param number of elements needed.
     *  
     */
    private void dfs(List<List<Integer>> res, List<Integer> comb, int[] nums, int start, int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        
        for (int i = start; i < nums.length && k > 0; ++i) {
            comb.add(nums[i]);
            dfs(res, comb, nums, i + 1, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
