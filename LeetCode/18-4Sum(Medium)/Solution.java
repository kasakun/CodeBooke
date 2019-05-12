class Solution {
    private int len = 0;
    
    private List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (index > len) return res;
        
        if (k == 2) {
            int  i = index, j = len - 1;
            
            while (i < j) {
                if (target - nums[i] == nums[j]) {
                    List<Integer> list = new ArrayList<>();
                    
                    list.add(nums[i]);list.add(nums[j]);
                    
                    res.add(list);
                    
                    while (i < j && nums[i] == nums[i + 1]) ++i;
                    while (i < j && nums[j] == nums[j - 1]) --j;
                    
                    ++i;--j;
                } else if (target - nums[i] > nums[j])
                    ++i;
                else
                    --j;
            }
        } else {
            for (int i = index; i < len - k + 1; ++i) {
                List<List<Integer>> temps = kSum(nums, target - nums[i], k - 1, i + 1);
                if (temps != null) {
                    for (List<Integer> temp : temps)
                        temp.add(0, nums[i]);

                    res.addAll(temps);
                }

                while (i < len - 1 && nums[i] == nums[i + 1]) ++i;
            }
        }
            
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        
        return kSum(nums, target, 4, 0);
    }
}