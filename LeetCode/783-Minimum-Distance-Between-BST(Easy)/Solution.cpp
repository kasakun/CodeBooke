/**
 ** Definition for a binary tree node.
 ** struct TreeNode {
 **     int val;
 **     TreeNode *left;
 **     TreeNode *right;
 **     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 ** };
 **/
class Solution {
private:
    int res = INT_MAX, prev = -1;
public:
    int minDiffInBST(TreeNode* root) {
        if (root->left != NULL) minDiffInBST(root->left);
        if (prev >= 0) res = min(res, root->val - prev);
        prev = root->val;
        if (root->right != NULL) minDiffInBST(root->right);

        return res;

    }

};

