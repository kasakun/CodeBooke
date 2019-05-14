/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * Recursion, not strict O(1), but I think it is more intuitive and easy to
 * realize in an interview
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode leftNotSorted = head, rightNotSorted = slow.next;

        slow.next = null;

        ListNode left = sortList(leftNotSorted);
        ListNode right = sortList(rightNotSorted);

        return merge(left, right);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }

            node = node.next;
        }

        if (l1 != null) node.next = l1;
        if (l2 != null) node.next = l2;

        return dummy.next;
    }
}