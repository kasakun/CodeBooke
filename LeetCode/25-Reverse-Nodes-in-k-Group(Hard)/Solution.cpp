/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
private:
    // start ,end is exclusive
    // return tail
    ListNode* reverse(ListNode* start, ListNode* end) {
        ListNode* prev = NULL;
        ListNode* head = start->next;
        ListNode* node = start->next;
        
        while (node != end) {
            ListNode* next = node->next;
            node->next = prev;
            
            prev = node;
            node = next;
        }
        
        start->next = prev;
        head->next = end;
        
        return head;
    }
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* dummy = new ListNode(0);
        
        dummy->next = head;
        
        ListNode* node = dummy;
        
        while (node != NULL) {
            int cnt = 0;
            ListNode* start = node;
            ListNode* end = node;
            
            while (end != NULL && cnt < k + 1) {
                end = end->next;
                ++cnt;
            }
            
            if (cnt == k + 1) {
                node = reverse(start, end);
            } else
                break;
        }
        
        return dummy->next;
    }
};

