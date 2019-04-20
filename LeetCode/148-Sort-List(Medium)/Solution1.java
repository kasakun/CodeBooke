/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * Strict O(1) space, using iteration
 */
class Solution1 {
    private ListNode mergeHead, mergeTail;
    
    private void merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        
        mergeTail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                mergeTail.next = l1;
                l1 = l1.next;
            } else {
                mergeTail.next = l2;
                l2 = l2.next;
            }
            
            mergeTail = mergeTail.next;
        }
        
        while (l1 != null) {
            mergeTail.next = l1;
            l1 = l1.next;
            mergeTail = mergeTail.next;
        }
        
        while (l2 != null) {
            mergeTail.next = l2;
            l2 = l2.next;
            mergeTail = mergeTail.next;
        }
        
        mergeHead = dummy.next;

    }

    private ListNode constructByLevel(ListNode dstNode, ListNode srcNode, int level) {
        int count = 1 << level;
        
        while (count > 0 && srcNode != null) {
            dstNode.next = srcNode;
            dstNode = dstNode.next;
            srcNode = srcNode.next;
            --count;
        }
        
        dstNode.next = null;
        
        return srcNode;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int level = 0, listLength = 0;
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode dummySorted = new ListNode(0);
        
        // pointer for origin list, pointer for sorted sublist
        ListNode node = head, nodeSorted = dummySorted;
        
        /**
         * In the first iteration, we get the length of the whole list
         */
        while (node != null && node.next != null) {
            // partition
            node = constructByLevel(dummy1, node, level);
            node = constructByLevel(dummy2, node, level);
            
            // merge
            merge(dummy1.next, dummy2.next);
            nodeSorted.next = mergeHead;
            nodeSorted = mergeTail;
            
            listLength += 2;
        }
        
        if (node != null) {
            nodeSorted.next = node;
            ++listLength;
        }
        
        ++level;
        
        /**
         * Merge logn levels
         */
        while (1 << level < listLength) {
            nodeSorted = dummySorted;
            node = dummySorted.next;
            
            while (node != null) {
                // partition
                node = constructByLevel(dummy1, node, level);
                node = constructByLevel(dummy2, node, level);

                // merge
                merge(dummy1.next, dummy2.next);
                nodeSorted.next = mergeHead;
                nodeSorted = mergeTail;
            }
            ++level;
        }
        
        return dummySorted.next;
    }
}