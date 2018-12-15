/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode curr = dummyHead;
        
        while (curr.next != null && curr.next.next != null) {
            ListNode temp = curr.next;
            
            curr.next = temp.next;
            temp.next = curr.next.next;
            curr.next.next = temp;
            
            curr = curr.next.next;
        }
        
        return dummyHead.next;
    }
}