/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode node = root;
        ListNode[] res = new ListNode[k];
        int num = 0;
        
        while (node != null) {
            ++num;
            node = node.next;
        }
        
        int numInPart = num/k, larger = num%k;
        node = root;
        for (int i = 0; i < k; ++i) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            for (int j = 0; j < numInPart + (i < larger ? 1 : 0); ++j) {
                curr.next = new ListNode(node.val);
                curr = curr.next;
                if (node != null) node = node.next;
            }
            res[i] = dummy.next;
        }
        
        return res;
    }
}