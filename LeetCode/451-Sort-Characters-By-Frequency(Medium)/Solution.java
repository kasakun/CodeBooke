class Solution {
    private class Node {
        char c;
        Node next;
        
        Node(char ch){ c = ch; }
    }
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Node[] buckets = new Node[s.length() + 1];
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(Character c : map.keySet()) {
            int index = map.get(c);
            if (buckets[index] == null) {
                buckets[index] = new Node(c);
            } else {
                Node temp = buckets[index];
                buckets[index] = new Node(c);
                buckets[index].next = temp;
            }
            System.out.println(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = buckets.length - 1; i > 0; --i) {
            Node node = buckets[i];
            while (node != null) {
                int count = i;
                
                while (count > 0) {
                    sb.append(node.c);
                    --count;
                }
                
                node = node.next;
            }
        }
        
        return sb.toString();
    }
}