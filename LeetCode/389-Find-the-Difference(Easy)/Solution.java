class Solution {
    public char findTheDifference(String s, String t) {
        int[] dict = new int[26];
        
        for (char c : s.toCharArray()) ++dict[c - 'a'];
        
        for (char c : t.toCharArray()) {
            --dict[c - 'a'];
            
            if (dict[c - 'a'] < 0) return c;
        }
        
        return 0;
    }
}