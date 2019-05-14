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
        ListNode dummy = new ListNode(0);
        
        dummy.next = head;
        
        ListNode prev = dummy, curr = head;
        
        
        while (curr != null) {
            //skip corner case caused by dummy
            if (prev == dummy && curr.val == 0) {
                prev = prev.next;
                curr = curr.next;
                continue;
            }
            if (prev.val == curr.val) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}