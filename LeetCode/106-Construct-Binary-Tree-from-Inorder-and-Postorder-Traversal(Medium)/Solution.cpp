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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder, int is, int ie, int ps, int pe) {
        if (ps > pe) return NULL;
        
        int id;
        TreeNode* node = new TreeNode(postorder[pe]);
        
        //find it in inorder list
        for (id = is; id < inorder.size(); ++id) {
            if (inorder[id] == node->val) break;
        }
        
        // decide position in postorder, minus numbers of elements after id in inorder
        node->left  = buildTree(inorder, postorder, is,  id - 1, ps, ps + id - is - 1);
        node->right = buildTree(inorder, postorder, id + 1, ie, pe - ie  + id, pe - 1);
        
        return node;
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return buildTree(inorder, postorder, 0,  inorder.size() - 1, 0, postorder.size() - 1);
    }
};

