/**
 * Definition for a Node
 *
 * class Node {
 * public:
 *     int val;
 *     vector<Node*> childred;
 *
 *     Node() {}
 *
 *     Node(int _val, vector<Node*> _children) {
 *         val = _val;
 *         children = _children;
 *     }
 * };
 */
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> result;
        if (root == NULL) return result;

        stack<Node*> _stack;
        _stack.push(root);
    
        while (!_stack.empty()) {
            Node* curr = _stack.top();
            _stack.pop();
            res.push_back(curr->val);

            for (int i = curr->children.size() - 1; i >= 0; --i) {
                if (curr->children[i] != NULL) {
                    _stack.push(curr->children[i]);
                }
            }
        }
    
        return res;
    }
};

