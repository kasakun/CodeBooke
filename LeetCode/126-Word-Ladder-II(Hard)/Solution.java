/**
 * 
 * Step 1: BFS, construct graph and find the min path
 * Step 2: DFS, find the path
 * 
 */
class Solution {
    private Set<String> dict;
    private Map<String, List<String>> graphNeighbours = new HashMap<>();
    private Map<String, Integer> distance = new HashMap<>();
    
    private List<String> getNeighbours(String curr) {
        char[] currChars = curr.toCharArray();
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < currChars.length; ++i) {
            char prevChar = currChars[i];
            for (char c = 'a'; c <= 'z'; ++c) {
                currChars[i] = c;
                String nextWord = new String(currChars);
                if (dict.contains(nextWord))
                    res.add(nextWord);
            }
            
            currChars[i] = prevChar;
        }

        return res;
    }
    
    /**
     * Construct graph
     */
    private void bfs(String beginWord, String endWord){
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            
            for (int i = 0; i < size; ++i) {
                String currWord = queue.poll();
                int currDistance = distance.get(currWord);
                List<String> neighbours = getNeighbours(currWord);
                
                for (String nextWord : neighbours) {
                    graphNeighbours.get(currWord).add(nextWord);
                    
                    if (!distance.containsKey(nextWord)) {
                        distance.put(nextWord, currDistance + 1);
                        
                        if (endWord.equals(nextWord))
                            found = true;
                        else
                            queue.offer(nextWord);
                    }
                }
            }
            
            if (found) break; // no need to go to next level; 
        }
        
        return;
    }
    
    
    private void dfs(String currWord, String endWord, List<String> solution, List<List<String>> res) {
        solution.add(currWord);
        if (endWord.equals(currWord)) {
           res.add(new ArrayList<String>(solution));
        } else {
           for (String nextWord : graphNeighbours.get(currWord)) {            
                if (distance.get(nextWord) == distance.get(currWord) + 1) {
                     dfs(nextWord, endWord, solution, res);
                }
            }
        }           
       solution.remove(solution.size() - 1);
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        dict = new HashSet<>(wordList);
        dict.add(beginWord);
        
        List<List<String>> res = new ArrayList<>();
        
        if (!dict.contains(endWord)) return res;
        
        for (String str : dict) graphNeighbours.put(str, new ArrayList<String>());

        bfs(beginWord, endWord);
        dfs(beginWord, endWord, new ArrayList<String>(), res);
        
        return res;
    }
}