/**
 * Graph + DFS
 */
class Solution {
private:
    unordered_map<string, vector<string>> graph;
    
    void dfs(vector<string>& seq, unordered_set<string>& visited, string curr) {
        if (visited.find(curr) != visited.end()) return;
        visited.insert(curr);
        seq.push_back(curr);
        for (auto& next: graph[curr])
            dfs(seq, visited, next);

        return;
    }
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        vector<vector<string>> res;
        unordered_set<string> visited;
        unordered_map<string, string> name_dict;
        
        for(int i = 0; i < accounts.size(); ++i) {
            int size = accounts[i].size();
            for (int j = 1; j < size; ++j) {
                // linke name to email
                name_dict[accounts[i][j]] = accounts[i][0];
                
                if (j == 1) continue;
                //construct graph
                graph[accounts[i][1]].push_back(accounts[i][j]);
                graph[accounts[i][j]].push_back(accounts[i][1]);
            }
        }


        for (auto& entry : name_dict) {
            if (visited.find(entry.first) != visited.end()) continue;
            vector<string> seq;
            dfs(seq, visited, entry.first);
            sort(seq.begin(), seq.end());
            seq.insert(seq.begin(), name_dict[seq[0]]);
            res.push_back(seq);
        }

        return res;
    }
};