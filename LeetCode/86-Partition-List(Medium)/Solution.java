/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        
        ListNode beforeTemp = before, afterTemp = after;
        while (head != null) {
            if (head.val < x) {
                beforeTemp.next = new ListNode(head.val);
                beforeTemp = beforeTemp.next;
            } else {
                afterTemp.next = new ListNode(head.val);
                afterTemp = afterTemp.next;
            }
            head = head.next;
        }
        
        beforeTemp.next = after.next;
        
        return before.next;
    }
}