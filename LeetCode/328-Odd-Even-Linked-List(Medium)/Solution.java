/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode curr = head, currEven = head.next, currOdd = head.next.next;
        
        while(currOdd !=null) {
            ListNode insertNode = currOdd;
            
            // take out currOdd
            currEven.next = currOdd.next;
            
            // insert currOdd after curr
            ListNode temp = curr.next;
            curr.next = insertNode;
            insertNode.next = temp;
           
            // reset currOdd, currEven
            if (currEven.next == null) break;
            currEven = currEven.next;
            currOdd = currEven.next;
            
            curr = curr.next;
        }
        
        return head;
    }
}

// 2 1 3 5 6 4 7
// 2 3 1 5 6 4 7
// 2 3 5 1 6 4 7
    