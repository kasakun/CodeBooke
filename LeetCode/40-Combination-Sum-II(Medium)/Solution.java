class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    private void combinationSum2Helper(int[] candidates, List<Integer> list, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; ++i) {
            // skip the same number in the same level
            if(i > start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            combinationSum2Helper(candidates, list, i + 1, remain - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
        
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, list, 0, target);
        
        return res;
    }
}