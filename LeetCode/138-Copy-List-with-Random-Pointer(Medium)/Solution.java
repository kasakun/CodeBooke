/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node node = head;
        
        Map<Node, Node> map = new HashMap<>();
        while (node != null) {
            map.put(node, new Node(node.val, null, null));
            node = node.next;
        }
        
        Node nHead = map.get(head);
        Node nNode = nHead;
        node = head;
        while (node != null) {
            nNode.next = map.get(node.next);
            nNode.random = map.get(node.random);
            
            node = node.next;
            nNode = nNode.next;
        }
        
        return nHead;
    }
}