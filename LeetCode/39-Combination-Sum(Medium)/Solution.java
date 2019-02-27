class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    
    private void combinationSumHelper(int[] candidates, List<Integer> list, int start, int remain) {
        if (remain < 0) return;
        
        if (remain == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; ++i) {
            list.add(candidates[i]);
            combinationSumHelper(candidates, list, i, remain - candidates[i]);
            list.remove(list.size() - 1);
        }
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        
        combinationSumHelper(candidates, list, 0, target);
        
        return res;
    }
}