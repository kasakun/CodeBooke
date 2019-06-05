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
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root == NULL) return res;
        
        stack<TreeNode*> stack;
        
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode* curr = stack.top();
            stack.pop();
            
            res.push_back(curr->val);
            
            if (curr->right != NULL)stack.push(curr->right);
            if (curr->left != NULL)stack.push(curr->left);
        }
        
        return res;
    }
};