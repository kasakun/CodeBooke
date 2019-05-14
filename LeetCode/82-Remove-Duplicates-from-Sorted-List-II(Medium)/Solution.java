/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        
        ListNode prev = dummy, curr = head, next = head.next;
        
        while (next != null) {
            if (curr.val == next.val) {
                while (next != null && next.val == curr.val) next = next.next;
                prev.next = next;
                curr = next;
                if (next == null) break;
                next = next.next;
            } else {
                prev = prev.next;
                curr = curr.next;
                next = next.next;
            }
        }

        return dummy.next;
    }
}