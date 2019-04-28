/**
 * Meomrization
 */
class Solution {
    private boolean contains(int[] targets, int curr) {
        for (int target : targets)
            if(target == curr) return true;
        
        return false;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> zeros = Arrays.asList(Arrays.asList(0));
        
        map.put(0, zeros);
        for (int i = 1; i < graph.length; ++i) {
            List<List<Integer>> newPaths = new ArrayList<>();

            for (int j = 0; j < i; ++j) {
                int[] targets = graph[j];
                if (!contains(targets, i)) continue;

                // get all paths from 0 to j
                List<List<Integer>> paths = map.get(j);
                
                for (List<Integer> path : paths) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(i);
                    // System.out.print(i);
                    newPaths.add(newPath);
                }
                
                map.put(i, newPaths);
            }
        }
        
        return map.get(graph.length - 1);
    }
}