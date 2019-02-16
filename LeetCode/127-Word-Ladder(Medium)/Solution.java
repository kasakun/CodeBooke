/**
 * BFS
 * 
 * The point is:
 * Why we need visted set?
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(); // if go to visited again, it must waste steps.
        
        queue.offer(beginWord);
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ++level;
            
            for (int i = 0; i < levelSize; ++i) {
                String currWord = queue.poll();
                
                if (currWord.equals(endWord)) {
                    return level;
                } else {
                    char[] currChars = currWord.toCharArray();
                    for (int j = 0; j < currChars.length; ++j) {
                        char prevChar = currChars[j];
                        for (char nextChar = 'a'; nextChar <= 'z'; ++nextChar) {
                            currChars[j] = nextChar;
                            String nextWord = new String(currChars);
                            if (dict.contains(nextWord) && !visited.contains(nextWord)) {
                                queue.offer(nextWord);
                                visited.add(nextWord);
                            }
                        }
                        currChars[j] = prevChar;
                    }
                }
            }
        }
        
        return 0;
    }
}