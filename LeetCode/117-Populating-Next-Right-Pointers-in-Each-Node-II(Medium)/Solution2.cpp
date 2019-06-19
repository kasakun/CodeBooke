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
O(1) space, take advantage of next chain
*/
class Solution {
public:
    Node* connect(Node* root) {
        if (root == NULL) return root;
        
        Node* prev;
        Node* curr = new Node();
        
        prev = root;
        prev->next = NULL;

        curr->next = root;
        
        while(curr->next) {
            curr->next = NULL;
            
            Node* pPrev = prev;
            Node* pCurr = curr;
            while (pPrev) {
                if (pPrev->left) {
                    pCurr->next = pPrev->left;
                    pCurr = pCurr->next;
                }
                if (pPrev->right) {
                    pCurr->next = pPrev->right;
                    pCurr = pCurr->next;
                }

                pPrev = pPrev->next;
            }
            
            prev = curr->next;
        }
        
        return root;
    }
};
