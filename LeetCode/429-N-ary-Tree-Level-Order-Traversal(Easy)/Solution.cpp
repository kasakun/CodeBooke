/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if (root == NULL) return res;
        
        queue<Node*> q;
        
        q.push(root);
        
        while (!q.empty()) {
            int size = q.size();
            vector<int> seq;
            
            while (size > 0) {
                auto node = q.front();
                q.pop();
                
                seq.push_back(node->val);
                
                for (auto& child : node->children)
                    q.push(child);
                
                --size;
            }
            
            res.push_back(seq);
        }
        
        return res;
    }
};