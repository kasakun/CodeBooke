class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if (n == 1) return vector<int>{0};
        queue<int> q;
        vector<int> res;
        vector<unordered_set<int>> graph(n);
        
        //construct graph
        for (auto edge : edges) {
            graph[edge[0]].insert(edge[1]);
            graph[edge[1]].insert(edge[0]);
        }
        
        for (int i = 0; i < n; ++i)
            if (graph[i].size() == 1) q.push(i);
        
        while (n > 2) {
            int size = q.size();
            
            n -= size;
            
            for (int i = 0; i < size; ++i) {
                int node = q.front();
                q.pop();
                
                for (auto neighbour : graph[node]) {
                    graph[neighbour].erase(node);
                    
                    if (graph[neighbour].size() == 1) q.push(neighbour);
                }
            }
        }
        
        while (!q.empty()) {
            res.push_back(q.front());
            q.pop();
        }
        
        return res;
    }
};

