/**
 * Use double linked list and map to realize.
 * 
 */
class LRUCache {
    private static class LRUNode {
        private LRUNode prev, next;
        private int key;
        private int val;
        
        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private final int capacity;
    private LRUNode head, tail;
    private HashMap<Integer, LRUNode> map = new HashMap<>();
    
    private void addToHead(LRUNode node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    
    private LRUNode remove(LRUNode node) {
        LRUNode prev = node.prev, next = node.next;
        
        prev.next = next;
        next.prev = prev;
        
        return node;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LRUNode(-1, -1);
        tail = new LRUNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        LRUNode node = map.get(key);
        if (node == null) return -1;
        remove(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        LRUNode node = map.get(key);
        
        if (node != null) {
            remove(node);
            node.val = value;
        } else {
            node = new LRUNode(key, value);
            map.put(key, node);
            
            if (map.size() > capacity) {
                map.remove(remove(tail.prev).key);
            }
        }
        
        addToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */