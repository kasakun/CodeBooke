class Solution {
    /*
     * mark:
     * 0 unvisited
     * 1 visited but unknown
     * 2 end or sub is end
     **/
    private boolean dfs (int node, int[] mark, int[][] graph) {
        if (mark[node] != 0) return mark[node] == 2;
        
        mark[node] = 1;
        
        for (int next : graph[node]) {
            if (mark[next] == 2) continue;
            
            if (mark[next] == 1 || !dfs(next, mark, graph)) return false;
            
        }
        
        mark[node] = 2;
        
        return true;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] mark = new int[graph.length];
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < graph.length; ++i)
            if (dfs(i, mark, graph))
                res.add(i);
        
        return res;
    }
}