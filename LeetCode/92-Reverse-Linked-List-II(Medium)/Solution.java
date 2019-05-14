/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if ((n - m) == 0) return head;
        
        int index = 1;
        int count = n - m + 1;
        ListNode prev, curr, start, prevStart;
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        curr = head;
        prev = dummy;
        
        while (index < m) {
            curr = curr.next;
            prev = prev.next;
            ++index;
        }

        prevStart = prev;        
        start = curr;
        
        prev = new ListNode(0);
        prev.next = curr;
        
        while (count > 0) {
            ListNode node = curr.next;
            curr.next = prev;

            // move to next
            prev = curr;
            curr = node;

            --count;
        }
        
        //curr is the end.next
        prevStart.next = prev;
        start.next = curr;
        
        return dummy.next;
    }
}