/**
 * Same as Word Ladder 
 * 
 * BFS
 */
class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
        unordered_set<string> geneBank;
        
        for (auto& gene : bank)
            geneBank.insert(gene);

        if (geneBank.find(end) == geneBank.end())
            return -1;
        
        int level = 0;
        char purines[] = {'A', 'C', 'G', 'T'};
        queue<string> _queue;
        unordered_set<string> visited;
        
        _queue.push(start);
        visited.insert(start);
        
        while (!_queue.empty()) {
            ++level;
            int levelSize = _queue.size();
            
            for (int i = 0; i < levelSize; ++i) {
                string curr = _queue.front();
                _queue.pop();
                
                if (curr == end)
                    return level - 1;
                else {
                    for (int j = 0; j < curr.size(); ++j) {
                        char prevPurine = curr[j];
                        for (auto& purine : purines) {
                            if (prevPurine == purine) continue;
                            
                            curr[j] = purine;
                            
                            if (geneBank.find(curr) != geneBank.end() &&
                                visited.find(curr) == visited.end()) {
                                _queue.push(curr);
                                visited.insert(curr);
                            }
                        }
                        curr[j] = prevPurine;
                    }
                }
            }
        }
            
        return -1;
        
    }
};