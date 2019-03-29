/**
 * Bucket sort
 */
class Solution1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        List<Integer>[] buckets = new List[nums.length + 1];
        Map <Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        
        for (int num : map.keySet()) {
            if (buckets[map.get(num)] == null)
                buckets[map.get(num)] = new LinkedList<>();
            buckets[map.get(num)].add(num);
        }
        
        for (int i = buckets.length - 1; i > 0 && k > 0; --i) {
            if (buckets[i] != null) {
                res.addAll(buckets[i]);
                k -= buckets[i].size();
            }
        }
        
        return res;
    }
}