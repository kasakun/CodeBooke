/**
 * The idea is simple:
 * if exists:
 * pick the most count in the remaining chars, if it is the same
 * as current char, then we will go to next most.
 * 
 * This is very tricky, I dont think I can remeber during interview.
 *
 */
class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            ++count;
            if (count > (S.length() + 1)/2) return "";
            map.put(c, count);
        }
        
        for (char c : map.keySet())
            pq.offer(new int[]{c, map.get(c)});
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }  
        }
        
        return sb.toString();
    }
}