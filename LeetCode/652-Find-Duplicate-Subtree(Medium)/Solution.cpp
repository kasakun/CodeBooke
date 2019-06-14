/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 *
 * The idea is to encode the tree via dfs.
 */
class Solution {
private:
    vector<TreeNode*> res;
    unordered_map<string, int> _map;
    
    string dfs(TreeNode* node) {
        if (node == NULL) return "#";
        
        string s = to_string(node->val) + "," + dfs(node->left) + "," + dfs(node->right);
        
        if (_map.find(s) == _map.end()) _map[s] = 1;
        else _map[s] += 1;

        if (_map[s] == 2) res.push_back(node); //only record once
        
        return s;
    }
public:
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        dfs(root);
        
        return res;
    }
};

