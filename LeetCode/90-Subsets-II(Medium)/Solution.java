class Solution {
    private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        res.add(list);
        
        for (int i = index; i < nums.length; ++i) {
            // skip the duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;
            
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(nums[i]);
            dfs(nums, i + 1, newList, res);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(nums, 0, new ArrayList<Integer>(), res);
        
        return res;
    }
}