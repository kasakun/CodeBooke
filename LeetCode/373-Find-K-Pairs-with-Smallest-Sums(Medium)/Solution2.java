/**
 * Consider nums1 = 1, 7, 11, 16; nums2 = 2, 9, 10, 15
 * 
 * what line  does is to push the head of lists below, remeber k sorted list?
 * 
 * (1,2) -> (1,9) -> (1,10) -> (1,15)
 * (7,2) -> (7,9) -> (7,10) -> (7,15)
 * (11,2) -> (11,9) -> (11,10) -> (11,15)
 * (16,2) -> (16,9) -> (16,10) -> (16,15) 
 *
 */
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        LinkedList<int[]> res = new LinkedList<>();
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]);
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;
    
        for (int i = 0; i < nums1.length; ++i) pq.offer(new int[]{nums1[i], nums2[0], 0});
        
        while (k-- > 0 && pq.size() != 0) {
            int[] temp = pq.poll();
            res.add(new int[]{temp[0], temp[1]});
            
            if (temp[2] == nums2.length - 1) continue;
            
            pq.offer(new int[]{temp[0], nums2[temp[2] + 1], temp[2] + 1});
        }
        
        return res;
    }
}