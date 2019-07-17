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
    int d[2] = {1, -1};
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        queue<TreeNode*> q;
        vector<vector<int>> res;
        int level = 0;
        
        if (root == NULL) return res;

        q.push(root);
        
        while (!q.empty()) {
            int size = q.size();
            vector<int> seq;
            
            while (size > 0) {
                TreeNode* node = q.front();
                q.pop();
                if (node->left != NULL) q.push(node->left);
                if (node->right != NULL) q.push(node->right);
                
                if (level%2 == 0) seq.push_back(node->val);
                else seq.insert(seq.begin(), node->val);
                
                --size;
            }
            
            ++level;
            res.push_back(seq);
        }
        
        return res;
    }
};

