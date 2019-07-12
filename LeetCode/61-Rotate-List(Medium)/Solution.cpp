/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == NULL) return head;
        int count = 0;
        ListNode *dummy = new ListNode(0);
        dummy->next = head;

        ListNode *node = head, *prev = dummy;
        
        while (node != NULL) {
            node = node->next;
            ++count;
        }
        
        k = count - k % count; // adjust k
        
        if (k == count) return head;
        
        node = head;
        
        while (k-- > 0) {prev = node; node = node->next;}
        
        dummy->next = node;
        
        while (node->next != NULL) node = node->next;
        
        node->next = head;
        prev->next = NULL;
        
        return dummy->next;
    }
};

