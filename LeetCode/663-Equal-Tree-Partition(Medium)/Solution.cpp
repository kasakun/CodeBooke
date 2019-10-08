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
    stack<int> visited;

    int sum(TreeNode* node) {
        if (node == NULL) return 0;

        visited.push(sum(node->left) + sum(node->right) + node->val);

        return visited.top();
    }
public:
    bool checkEqualTree(TreeNode* root) {
        int total = sum(root);

        visited.pop();

        if (total % 2 == 0)
            while (!visited.empty()) {
                if (visited.top() == total / 2)
                    return true;
                visited.pop();
            }
        return false;
    }
};

