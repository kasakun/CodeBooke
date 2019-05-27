/**
 * key point is 
 * You must use all tickets
 * 
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Stack<String> dfs = new Stack<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> res= new ArrayList<>();
        
        if (tickets.size() == 0) return res;
        
        // construct graph
        for (List<String> pair : tickets) {
            if (!graph.containsKey(pair.get(0)))
                graph.put(pair.get(0), new PriorityQueue<String>());
            graph.get(pair.get(0)).offer(pair.get(1));
        }
        
        dfs.push("JFK");
        
        while (!dfs.isEmpty()) {
            String next = dfs.peek();
            
            // dest exists
            if (graph.containsKey(next) && !graph.get(next).isEmpty())
                dfs.push(graph.get(next).poll());
            else {
                // end of dfs
                res.add(next);
                dfs.pop();
            }   
        }
        
        Collections.reverse(res);
            
        return res;
    }
}