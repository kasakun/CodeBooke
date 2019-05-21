/**
 * dfs, not good
 *
 * check each possible route to make sure it does not make a circle
 */
 class Solution2 {
    private boolean dfs(List<Integer>[] graph, boolean[] visited, int course) {
        if (visited[course]) return false;
        
        visited[course] = true;
        
        for (int next : graph[course]) {
            if (!dfs(graph, visited, next)) return false;
        }
        
        visited[course] = false;
        
        return true;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        List<Integer>[] graph = new List[numCourses];
        
        //construct graph
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] pair : prerequisites) {
            graph[pair[0]].add(pair[1]);
        }
        
        // check each route is not circled.
        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(graph, visited, i)) return false;
        }
        
        return true;
    }
}