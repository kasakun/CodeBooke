/**
 * Max Heap
 */
class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        Map <Integer, Integer> map = new HashMap<>();
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>((entry1, entry2) -> (entry2.getValue() - entry1.getValue()));
        
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        
        while (res.size() < k) {
            res.add(maxHeap.poll().getKey());
        }
        
        return res;
    }
}