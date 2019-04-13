/**
 * maxHeap PQ 
 */
class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        // Descending
        Queue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                pq.add(matrix[i][j]);
                if (pq.size() > k)
                    pq.poll();
            }
        }
        
        return pq.poll();
    }
}