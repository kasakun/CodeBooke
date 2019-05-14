/**
 * Priority Queue(Min Heap)
 * 
 * Time complexity: O(Nlogk)
 * 
 * Space complexity: O(N) for the new list
 *                   O(k) for the queue
 * 
 * Defination of singly-linked list.
 * 
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    class nodeComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return ((ListNode)o1).val - ((ListNode)o2).val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null, temp = null;
        PriorityQueue queue = new PriorityQueue<ListNode>(13, new nodeComparator());

        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null)
                queue.add(lists[i]); // add each list head to the pq
        }

        res = (ListNode) queue.poll();
        if (res == null)
            return res;
        if (res.next != null)
            queue.add(res.next);
        temp = res;
        
        while (!queue.isEmpty()) {
            ListNode node = (ListNode)queue.poll();
            // add next ele in the list if exists
            if (node.next != null)
                queue.add(node.next);
            temp.next = node;
            temp = temp.next;
        }
    }
}
