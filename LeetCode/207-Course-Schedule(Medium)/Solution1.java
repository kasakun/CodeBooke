/**
 * BFS
 * The idea is to take advantage of indegrees
 */
class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>[] graph = new List[numCourses];
        int[] indegrees = new int[numCourses];
        
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] pair : prerequisites) {
            ++indegrees[pair[1]];
            graph[pair[0]].add(pair[1]);
        }
        
        for (int i = 0; i < numCourses; ++i) {
            if (indegrees[i] == 0) {
                ++count;
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int next : graph[curr]) {
                --indegrees[next];
                if (indegrees[next] == 0) {
                    ++count;
                    queue.offer(next);
                }
            }
        }
        
        return count == numCourses;
    }
}