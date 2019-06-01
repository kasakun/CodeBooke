/**
 * Construct a graph, then DFS
 * 
 */
class Solution {
private:
    unordered_map<string, vector<pair<string, double>>> graph;
    
    pair<bool, double> dfs(string& target, string& current, unordered_set<string>& visited, double value) {
        if (visited.count(current) > 0)
            return make_pair(false, -1.0);

        visited.insert(current);
        
        for (auto& next: graph[current]) {
            double temp = value*next.second;
            if (next.first == target) return make_pair(true, temp);
            
            auto result = dfs(target, next.first, visited, temp);
            if (result.first) return result;
        }
        
        return make_pair(false, -1.0);
    }
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        vector<double> res;
        if (equations.empty()) return res;
        
        // construct graph
        for (int i = 0; i < equations.size(); ++i) {
            graph[equations[i][0]].push_back(make_pair(equations[i][1], values[i]));
            graph[equations[i][1]].push_back(make_pair(equations[i][0], 1.0/values[i]));
        }

        // dfs
        for (auto& query : queries) {
            unordered_set<string> visited;
            
            auto result = dfs(query[1], query[0], visited, 1.0);
            
            // cout << query[0] << " " << query[1] << " " << graph.count(query[0]) << endl;
            // uncomment the line above, looks like count return 1 even the key does not exist.
            if (query[0] == query[1] && graph.find(query[0]) == graph.end())
                res.push_back(1.0);
            else
                res.push_back(result.second);
        }
        
        return res;
    }
};