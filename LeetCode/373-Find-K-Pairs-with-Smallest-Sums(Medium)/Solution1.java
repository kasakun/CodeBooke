/**
 * The most intuitive way to think of.
 * O(n^2*logn)
 */
class Solution1 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        LinkedList<int[]> res = new LinkedList<>();
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]);
        
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                pq.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        
        while (k-- > 0 && pq.size() != 0) res.add(pq.poll());
        
        return res;
    }
}