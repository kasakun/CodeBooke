/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
private:
    unordered_map<TreeNode*, TreeNode*> parent;
    
    void dfs(TreeNode* node, TreeNode* par) {
        if (node == NULL) return;
        
        parent[node] = par;
        
        dfs(node->left, node);
        dfs(node->right, node);
    }
public:
    vector<int> distanceK(TreeNode* root, TreeNode* target, int K) {
        //construct parent
        dfs(root, NULL);
        
        int level = 0;
        vector<int> res;
        queue<TreeNode*> q;
        unordered_set<TreeNode*> visited;
        
        q.push(target);
        visited.insert(target);
        
        while (!q.empty() && level < K) {
            ++level;
            
            int size = q.size();
            
            while (size > 0) {
                TreeNode* node = q.front();
                q.pop();

                if (node->left && visited.find(node->left) == visited.end()) {
                    visited.insert(node->left);
                    q.push(node->left);
                }
                if (node->right && visited.find(node->right) == visited.end()) {
                    visited.insert(node->right);
                    q.push(node->right);
                }

                TreeNode* par = parent[node];
                if (par != NULL && visited.find(par) == visited.end()) {
                    visited.insert(par);
                    q.push(par);
                }
                --size;
            }
        }
        
        while (!q.empty()) {
            TreeNode* node = q.front();
            res.push_back(node->val);
            q.pop();
        }
        
        return res;
    }
};

