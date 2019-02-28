class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    private void combinationSum3Helper(List<Integer> list, int start, int remain, int k) {
        if (remain < 0 || k < 0) return;
        if (remain == 0 && k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i < 10; ++i) {
            list.add(i);
            combinationSum3Helper(list, i + 1, remain - i, k - 1);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        combinationSum3Helper(list, 1, n, k);
        
        return res;
    }
}