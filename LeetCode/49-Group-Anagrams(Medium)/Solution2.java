/**
 * Hash Table
 */
 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            int[] dict = new int[26];
            
            for (char ch : str.toCharArray()) ++dict[ch - 'a'];
            
            StringBuilder sb = new StringBuilder();
            for (int num : dict) {
                sb.append("#");
                sb.append(num);
            }
            
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            
            map.get(key).add(str);
                
        }
        
        return new ArrayList<>(map.values());
    }
}