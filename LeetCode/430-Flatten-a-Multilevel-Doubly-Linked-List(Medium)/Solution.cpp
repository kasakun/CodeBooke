/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;

    Node() {}

    Node(int _val, Node* _prev, Node* _next, Node* _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
public:
    Node* flatten(Node* head) {
        for (Node* node = head; node != NULL; node = node->next) {
            if (node->child) {
                Node* next = node->next;
                node->next = node->child;
                node->next->prev = node;
                node->child = NULL;
                
                Node *p = node;
                while(p->next) p = p->next;
                p->next = next;
                
                if (next) next->prev = p;
            }
        }
        return head;
    }
};