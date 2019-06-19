/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() {}

    Node(int _val, Node* _left, Node* _right, Node* _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

This is not O(1) space
*/
class Solution {
public:
    Node* connect(Node* root) {
        if (root == NULL) return root;

        queue<Node*> q;
        q.push(root);
        
        while(!q.empty()) {
            int size = q.size();
            
            while (size > 0) {
                Node* node = q.front();
                q.pop();
                --size;
                
                if (size == 0) node->next = NULL;
                else node->next = q.front();
                
                if (node->left) q.push(node->left);
                if (node->right) q.push(node->right);
            }
        }
        
        return root;
    }
};

