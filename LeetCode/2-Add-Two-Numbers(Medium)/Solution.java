/**
 * 
 * Defination for single-linked list.
 * 
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode sum = null, curr = null;

        while (l1 != null || l2 != null || c > 0) {
            int add = (l1 == null ? 0 : l1.val) +
                      (l2 == null ? 0 : l2.val) +
                      c;
            
            c = add/10;
            add = add%10;

            if (sum == null) {
                // First Node
                sum = new ListNode(add);
                curr = sum;
            } else {
                curr.next = new ListNode(add);
                curr = curr.next;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
    }
 }